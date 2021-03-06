import org.gradle.api.JavaVersion

object Modules {
    const val app = ":app"
    const val core = ":core"
    const val model = ":model"
    const val repository = ":repository"
    const val utils = ":utils"

    const val mainScreen = ":mainScreen"
    const val descriptionScreen = ":descriptionScreen"
    const val historyScreen = ":historyScreen"
}

object Config {
    const val sdk_version = 30
    const val build_tools = "30.0.3"
    const val application_id = "pt.svcdev.dictionary"
    const val min_sdk_version = 21
    const val version_code = 1
    const val version_name = "1.0"
    val java_version = JavaVersion.VERSION_1_8
}

object Versions {
    // Design
    const val appcompat = "1.2.0"
    const val swipeRefreshLayout = "1.0.0"
    const val material = "1.3.0"

    // Glide
    const val glide = "4.9.0"

    // Koin
    const val koin = "2.0.1"

    // Kotlin
    const val kotlin_core_ktx = "1.0.2"
    const val kotlin_stdlib_jdk = "1.4.30"
//    const val kotlin_stdlib_jdk = "1.3.41"
    const val coroutines_core = "1.2.1"
    const val coroutines_android = "1.1.1"

    // Picasso
    const val picasso = "2.5.2"

    // Retrofit
    const val retrofit = "2.9.0"
    const val retrofit_converter_gson = "2.9.0"
    const val loggin_interceptor = "3.12.1"
    const val coroutines_adapter = "0.9.2"

    // Room
    const val room = "2.2.6"

    // TestImpl
    const val junit = "4.13.2"
    const val test_runner = "1.3.0"
    const val espresso = "3.3.0"
}

object Design {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val swiperefreshlayout =
        "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshLayout}"
    const val material = "com.google.android.material:material:${Versions.material}"
}

object Glide {
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glide_compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
}

object Koin {
    const val koin = "org.koin:koin-android:${Versions.koin}"
    const val viewmodel = "org.koin:koin-android-viewmodel:${Versions.koin}"
}

object Kotlin {
    const val core_ktx = "androidx.core:core-ktx:${Versions.kotlin_core_ktx}"
    const val stdlib_jdk = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin_stdlib_jdk}"
    const val coroutines_core =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines_core}"
    const val coroutines_android =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines_android}"
}

object Picasso {
    const val picasso = "com.squareup.picasso:picasso:${Versions.picasso}"
}

object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val converter_gson =
        "com.squareup.retrofit2:converter-gson:${Versions.retrofit_converter_gson}"
    const val loggin_interceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.loggin_interceptor}"
    const val coroutines_adapter =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.coroutines_adapter}"
}

object Room {
    const val room_runtime = "androidx.room:room-runtime:${Versions.room}"
    const val room_compiler = "androidx.room:room-compiler:${Versions.room}"
    const val room_ktx = "androidx.room:room-ktx:${Versions.room}"
}

object TestImpl {
    const val junit = "junit:junit:${Versions.junit}"
    const val runner = "androidx.test:runner:${Versions.test_runner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}
