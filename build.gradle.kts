buildscript {
    val agp_version by extra("8.0.2")
}
//buildscript {
//    val agp_version by extra("8.0.0")
//    dependencies {
//        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.3")
//        classpath ("com.android.tools.build:gradle:$agp_version")
//        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.0")
//        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.44.2") /* 2.35 */
//    }
//}
//buildscript {
//    ext {
//        var compose_ui_version = ("1.2.0")
//        var agp_version = ("7.4.1")
//        agp_version1 = ("8.0.0")
//        agp_version2 = ("7.4.1")
//        agp_version3 = ("8.0.0")
//    }
//}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0" apply false /* 8.0.2 */
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false /* 1.8.10 */
    id ("com.android.library") version "8.1.0" apply false
    id ("com.google.dagger.hilt.android") version "2.44.2" apply false
    id("com.google.devtools.ksp") version "1.8.10-1.0.9" apply false
}