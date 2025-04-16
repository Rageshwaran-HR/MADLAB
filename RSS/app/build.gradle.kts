plugins {
    alias(libs.plugins.android.application) // Make sure this alias is configured in your settings
}

android {
    namespace = "com.example.rss"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.rss"
        minSdk = 24
        //noinspection OldTargetApi
        targetSdk = 35
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
}

dependencies {
    // Adding required dependencies
    implementation(libs.jsoup) // Jsoup for parsing RSS feeds
    implementation(libs.recyclerview) // RecyclerView for displaying list items
    implementation(libs.appcompat.v141) // For AppCompatActivity
    implementation(libs.material.v150) // Material components for UI
    implementation(libs.activity.ktx) // Activity KTX for better lifecycle handling
    implementation(libs.constraintlayout.v213) // For UI layouts

    // Testing dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.junit.v113)
    androidTestImplementation(libs.espresso.core.v340)
}
