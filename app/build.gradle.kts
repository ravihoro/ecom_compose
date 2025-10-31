plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kotlinCompose)

    alias(libs.plugins.hiltPlugin)
    alias(libs.plugins.kotlinKapt)
}

android {
    namespace = "com.example.ecom"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.ecom"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {
    implementation(libs.androidxCoreKtx)
    implementation(libs.androidxLifecycleRuntimeKtx)
    implementation(libs.androidxActivityCompose)

    // Compose BOM + UI
    implementation(platform(libs.composeBomLib))
    implementation(libs.composeUi)
    implementation(libs.composeUiGraphics)
    implementation(libs.composeUiToolingPreview)
    implementation(libs.composeMaterial3)
    debugImplementation(libs.composeUiTooling)
    androidTestImplementation(libs.composeUiTestJunit4)
    debugImplementation(libs.composeUiTestManifest)

    // Hilt (runtime + annotation processor)
    implementation(libs.hiltAndroid)
    kapt(libs.hiltCompiler)
    implementation(libs.hiltNavigationComposeLib)

    // Networking / serialization / image loading / coroutines
    implementation(libs.retrofitLib)
    implementation(libs.retrofitKotlinxConverter)
    implementation(libs.kotlinxSerializationJson)
    implementation(libs.okhttpLib)
    implementation(libs.okhttpLogging)
    implementation(libs.coilCompose)
    implementation(libs.kotlinxCoroutinesCore)
    implementation(libs.kotlinxCoroutinesAndroid)

    // Tests
    testImplementation(libs.junitLib)
    androidTestImplementation(libs.androidxJunit)
    androidTestImplementation(libs.androidxEspressoCore)
}