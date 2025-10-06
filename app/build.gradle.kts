plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kapt)
    alias(libs.plugins.google.services)
}

android {
    namespace = "com.example.studentstudybuddy"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.studentstudybuddy"
        minSdk = 25
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    // ...
    buildFeatures {
        // Enable View Binding
        viewBinding = true
    }
}

dependencies {
    // Core & UI (XML-based)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat) // For AppCompatActivity
    implementation(libs.google.android.material) // For Material Design components
    implementation(libs.androidx.constraintlayout) // For ConstraintLayout

    // Navigation Component (for Fragments)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    // ViewModel and LiveData
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.fragment.ktx)

    // Firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.auth)
    implementation(libs.firebase.firestore)

    // Hilt (Dependency Injection)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    // Retrofit (for API calls)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}