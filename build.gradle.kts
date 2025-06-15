buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.android.gradle.plugin)
        classpath(libs.google.services)
        classpath(libs.kotlin.gradle.plugin)
        classpath(libs.navigation.safe.args.gradle.plugin)
    }
    extra["apple"] = mapOf("emoji" to "🍎", "price" to 42)
}

plugins {
    alias(libs.plugins.compose.compiler) apply false // https://developer.android.com/develop/ui/compose/compiler#version-catalog
    alias(libs.plugins.hilt) apply false // https://developer.android.com/training/dependency-injection/hilt-android#setup
    alias(libs.plugins.ksp) apply false // https://developer.android.com/build/migrate-to-ksp#add-ksp
}
