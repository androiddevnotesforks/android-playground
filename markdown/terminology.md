# Known direct subclass
* is a direct subclass in the same library.
* For example, FileProvider is a direct subclass of ContentProvider, but not a "known" direct subclass of ContentProvider because FileProvider as is part of the AndroidX Core Library, while ContentProvider is not.
https://developer.android.com/jetpack/androidx/releases/core#declaring_dependencies

# Main-safe function
* means that the function is safe to call from the main thread. The function does not block the thread because it runs on the background thread.
* For example, suspend functions are main-safe.