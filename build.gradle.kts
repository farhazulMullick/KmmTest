buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    dependencies {
        classpath( "dev.icerock.moko:resources-generator:0.23.0")
    }

}
plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.androidApplication).apply(false)
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinAndroid).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    alias(libs.plugins.ksp).apply(false)
    alias(libs.plugins.compose).apply(false)
    alias(libs.plugins.kotlinSerialization).apply(false)
}
