buildscript {
    dependencies {
        classpath(libs.navigation.safe.args.gradle.plugin) // https://developer.android.com/guide/navigation/use-graph/safe-args#enable
    }
    extra["apple"] = mapOf("emoji" to "🍎", "price" to 42)
}

plugins {
    alias(libs.plugins.android.gradle.plugin) apply false // https://developer.android.com/build/releases/gradle-plugin#updating-plugin
    alias(libs.plugins.compose.compiler) apply false // https://developer.android.com/develop/ui/compose/compiler#version-catalog
    alias(libs.plugins.google.services) // https://firebase.google.com/docs/android/setup#add-config-file
    alias(libs.plugins.hilt) apply false // https://developer.android.com/training/dependency-injection/hilt-android#setup
    alias(libs.plugins.ksp) apply false // https://developer.android.com/build/migrate-to-ksp#add-ksp
}
