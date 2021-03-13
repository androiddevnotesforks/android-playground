# Note
* DI is done at compile time instead of runtime unlike Kodein/Koin.
* @Provides ⊆ @Module ⊆ @Module ⊆ @Component = graph-of-dependencies

# The application graph
* is a graph of dependencies.
* is the class `Dagger<ComponentName>`, such as `DaggerAppComponent`, generated by Dagger at compile time.

# @Component
* is what you should look for when you take over an Android project because the parameters of methods in the interface define which classes request an injection.
* annotates an interface
  * whose name is "AppComponent" as convention.
  * is also annotated with @Singleton as convention.
  * take modules as attributes so that the Component can access those modules.
  * contains methods whose parameters are a class that request an injection.
    * i.e. `fun inject(activity: FooActivity)`, which means that FooActivity requests an injection.
  * contains an interface
    * annotated with `@Component.Factory`.
    * contains `fun create(@BindsInstance context: Context): FooComponent`
      * which means that context passed in will be available in the application graph.
* creates a graph of dependencies.

# @Module
* annotates a regular class or an abstract class
  * whose name is "<ReturnedInterface>Module" as convention.
  * The annotated class is an abstract class if it contains abstract methods annotated with @Binds.
    * i.e. abstract fun provide<ReturnedInterface>(returnedInterface: ClassThatImplementsReturnedInterface): <ReturnedInterface>
  * The annotated class is a regular class if it contains regular methods annotated with @Provides.
    * https://developer.android.com/training/dependency-injection/dagger-android#injecting-activities
* provides interfaces.

# @Inject
* annotates a constructor tells Dagger how to create instances of the class.
* annotates a class field tells Dagger to populate it.
  * Note: Field injection should only be used in Android framework classes where constructor injection cannot be used. (said the official reference)
  * https://developer.android.com/training/dependency-injection/dagger-android
* gets data from @Provides.

# @Binds and @Provides
* The codelab says that @Binds is recommended over @Provided because @Binds generates less code and therefore it's more efficient.
  * https://codelabs.developers.google.com/codelabs/android-dagger/index.html#14
* @Provides is to provide a class that your project does not own (e.g. Retrofit).
  * https://developer.android.com/training/dependency-injection/dagger-android#injecting-activities
  * https://codelabs.developers.google.com/codelabs/android-dagger/index.html#14

# @Qualifier
* is recommended over @Named because
   * They can be stripped out from Proguard or R8
   * You don't need to keep a shared constant for matching the names
   * They can be documented
* https://codelabs.developers.google.com/codelabs/android-dagger/index.html#14

# Using Dagger in multi-module apps
* The app module
  * normally contains the Application class.
  * should contain singleton Dagger modules of your app.
  * should contain Dagger modules that persist until the app shut down.

# @Singleton
* is NOT a reserved word and just the same as other scope annotations.

# Scope annotation (such as @ActivityScope)
* annotates a Component, an Activity, and (optionally) injectable classes.
  * which makes injectable classes singleton inside the Component.
  * As convention, developers write code to make a @FooScope Activity create a reference to a @ActivityScope Component in the Activity's onCreate() and the Activity holds the reference to the Component so that whenever the Activity is created, the Component is created.
    * Moreover, whenever the Activity is destroyed, the Component is destroyed.
* Even if different Components have the same scope annotation, they have different lifetimes.

# Scoping rules:
* When a type is marked with a scope annotation, it can only be used by Components that are annotated with the same scope.
* When a Component is marked with a scope annotation, it can only provide types with that annotation or types that have no annotation.
* A subcomponent cannot use a scope annotation used by one of its parent Components.

# References
* https://developer.android.com/training/dependency-injection/dagger-basics
* https://codelabs.developers.google.com/codelabs/android-dagger
* https://dagger.dev/faq.html
  * Useful FAQs:
    * Why is @Binds different from @Provides?
    * Why can’t @Binds and instance @Provides methods go in the same module?