plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.demox.presentation.base_ui"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdkVersion

        testInstrumentationRunner = Config.androidTestInstrumentation
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerVersion = "1.7.10"
        kotlinCompilerExtensionVersion = "1.2.0"
    }
}

dependencies {

    implementation(Dependencies.Android.Compose.ui)
    implementation(Dependencies.Android.Compose.material)
    implementation(Dependencies.Android.Compose.tooling)
    implementation(Dependencies.Android.Compose.icons)
    implementation(Dependencies.Android.Compose.composeMaterialIconsExtended)
    implementation("androidx.test.ext:junit-ktx:1.1.4")
    implementation("androidx.test:monitor:1.5.0")
    testImplementation("junit:junit:4.12")
    androidTestImplementation("junit:junit:4.12")
    implementation(Dependencies.Other.accompanistPermission)
}
