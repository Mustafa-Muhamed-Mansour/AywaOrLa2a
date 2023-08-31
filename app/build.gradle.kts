
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id ("com.google.dagger.hilt.android")
    id ("kotlin-parcelize")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.aywaorla2a"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.aywaorla2a"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17 /* VERSION_1_8 */
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3" /* 1.2.0 */
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    dataBinding {
        enable = true
    }
}

dependencies {

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation ("androidx.core:core-ktx:1.10.1")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("com.google.android.material:material:1.9.0")
    implementation ("androidx.navigation:navigation-fragment-ktx:2.6.0")
    implementation ("androidx.navigation:navigation-ui-ktx:2.6.0")
    implementation ("androidx.legacy:legacy-support-v4:1.0.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
    implementation("androidx.compose.material:material:1.4.0-beta01")
    implementation ("com.google.accompanist:accompanist-swiperefresh:0.24.13-rc")
    implementation ("androidx.activity:activity-compose:1.7.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07")
    implementation ("androidx.compose.runtime:runtime-livedata:1.0.4")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.google.code.gson:gson:2.10")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.4") /* 5.0.0-alpha.4 */

    //Coil
    implementation ("io.coil-kt:coil-compose:2.2.2") /* 1.4.0 */
    implementation("io.coil-kt:coil-gif:2.2.2")


    //SDP & SSP
    implementation ("com.github.Kaaveh:sdp-compose:1.1.0")


    //Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

    //Lottie-Animation
    implementation ("com.airbnb.android:lottie:6.0.0") /* 3.6.1 */


    //Dagger-Hilt
    implementation ("com.google.dagger:hilt-android:2.44.2")
    kapt ("com.google.dagger:hilt-android-compiler:2.44.2")
    annotationProcessor ("com.google.dagger:hilt-compiler:2.44.2")

    constraints {
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.8.0") {
            because("kotlin-stdlib-jdk7 is now a part of kotlin-stdlib")
        }
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.0") {
            because("kotlin-stdlib-jdk8 is now a part of kotlin-stdlib")
        }
    }
}