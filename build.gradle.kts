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
        classpath(libs.oss.licenses.plugin)
        classpath(libs.realm.gradle.plugin)
    }
}

plugins {
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.ksp)
    alias(libs.plugins.ktlint)
}

allprojects {
    afterEvaluate {
        apply(plugin = libs.plugins.ktlint.get().pluginId)

        // https://github.com/JLLeitschuh/ktlint-gradle/blob/main/plugin/src/main/kotlin/org/jlleitschuh/gradle/ktlint/KtlintExtension.kt
        configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
            android.set(true)
        }
    }
}
