plugins {
    id(Plugins.AGP.application)
    id(Plugins.Kotlin.android)
    id(Plugins.Kotlin.kapt)
    id(Plugins.DaggerHilt.hilt)
}

android {
    namespace = 'com.geektech.hw1mouth7'
    compileSdk = 32

    defaultConfig {
        applicationId = "com.geektech.hw1mouth7"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            minifyEnabled = false
            proguardFiles (getDefaultProguardFile('proguard-android-optimize.txt'),
                    'proguard-rules.pro'
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = '1.8'
    }

    buildFeatures{
        viewBinding = true
    }
}

dependencies {
    // Modules
    implementation(project(":domain"))
    implementation(project(":data"))

    // UI
    implementation(Dependencies.UI.constraint)
    implementation(Dependencies.UI.androidCore)
    implementation(Dependencies.UI.appCompat)
    implementation(Dependencies.UI.material)
    implementation(project(mapOf("path" to ":data")))
    testImplementation(Dependencies.UI.jUnit)
    androidTestImplementation(Dependencies.UI.extJUnit)
    androidTestImplementation(Dependencies.UI.espresso)

    // Javax
    implementation(Dependencies.Javax.inject)

    // Lifecycle
    implementation(Dependencies.Lifecycle.runtime)
    implementation(Dependencies.Lifecycle.viewModel)

    // Navigation
    implementation(Dependencies.Navigation.navUI)
    implementation(Dependencies.Navigation.fragment)

    // ViewBindingDelegate
    implementation(Dependencies.ViewBindingDelegate.delegate)

    // Coroutines
    implementation(Dependencies.Coroutines.android)

    // Dagger-Hilt
    implementation(Dependencies.DaggerHilt.android)
    kapt(Dependencies.DaggerHilt.compiler)

    // Room
    implementation(Dependencies.Room.room)
    kapt(Dependencies.Room.compiler)
    implementation(Dependencies.Room.runtime)
}
