import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.demox.presentation.search"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerVersion = "1.6.10"
        kotlinCompilerExtensionVersion = "1.2.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    api(project(Modules.Presentation.BASE_UI))
    api(project(Modules.Domain.SEARCH))
    api(project(Modules.Data.SEARCH))

    implementation(Dependencies.Android.Compose.ui)
    implementation(Dependencies.Android.Compose.material)
    implementation(Dependencies.Android.Compose.runtime)
    implementation(Dependencies.Android.Compose.icons)
    implementation(Dependencies.Android.Compose.tooling)
    implementation(Dependencies.Android.Compose.composeUiToolingPreview)
    implementation(Dependencies.Android.Compose.composeMaterialIconsExtended)
    implementation(Dependencies.ViewModel.viewmodelKTX)

    implementation(Dependencies.Di.hilt)
    implementation(Dependencies.Di.hiltNavigation)
    implementation("androidx.test:monitor:1.5.0")
    implementation("androidx.test.ext:junit-ktx:1.1.4")
    testImplementation("junit:junit:4.12")
    kapt(Dependencies.Di.hiltCompiler)
}
