import gradle.kotlin.dsl.accessors._4b7ad2363fc1fce7c774e054dc9a9300.implementation
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

plugins {
    id("com.android.library")
    id("application-setup")
    kotlin("android")
}

dependencies {
    implementation(Dependencies.Android.Compose.runtime)
    implementation(Dependencies.Android.Compose.ui)
    implementation(Dependencies.Android.Compose.material)
    implementation(Dependencies.Android.Compose.icons)
    implementation(Dependencies.Android.Compose.tooling)
}
