

object Dependencies {

    object Android {
        const val gradlePlugin = "com.android.tools.build:gradle:7.2.2"
        const val composeActivity = "androidx.activity:activity-compose:1.5.1"

        object Compose {
            private const val version = "1.2.0"
            const val runtime = "androidx.compose.runtime:runtime:$version"
            const val ui = "androidx.compose.ui:ui:$version"
            const val material = "androidx.compose.material:material:$version"
            const val tooling = "androidx.compose.ui:ui-tooling:$version"
            const val icons = "androidx.compose.material:material-icons-core:$version"
            const val composeMaterialIconsExtended = "androidx.compose.material:material-icons-extended:$version"
            const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:$version"
        }
    }

    object ViewModel {
        private const val version = "2.3.1"
        const val viewmodelKTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
    }

    object Kotlin {
        private const val version = "1.6.10"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"

        object Serialization {
            const val gradlePlugin = "org.jetbrains.kotlin:kotlin-serialization:1.6.21"
            const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-core:1.3.0"
        }

        object Coroutines {
            private const val version = "1.6.0"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        }
    }

    object Room {
        private const val version = "2.4.2"
        const val room = "androidx.room:room-runtime:$version"
        const val roomKTX = "androidx.room:room-ktx:$version"
        const val roomCompiler = "androidx.room:room-compiler:$version"
    }

    object Navigation {
        const val composeNavigation = "androidx.navigation:navigation-compose:2.6.0-alpha04"
        const val hiltNavigation = "androidx.hilt:hilt-navigation-compose:1.0.0"
    }

    object Di {
        private const val version = "2.42"
        const val hilt = "com.google.dagger:hilt-android:$version"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:$version"
        const val hiltNavigation = "androidx.hilt:hilt-navigation-compose:1.0.0"
    }

    object Network {
        private const val version = "2.5.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val retrofitConvertor = "com.squareup.retrofit2:converter-gson:$version"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
    }

    object Other {
        const val accompanistPermission = "com.google.accompanist:accompanist-permissions:0.28.0"
    }
}
