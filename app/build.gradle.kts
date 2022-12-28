import java.io.FileInputStream
import java.util.Properties

plugins {
    id("kr.pe.ssun.application")
    id("kr.pe.ssun.application.compose")
    id("kr.pe.ssun.hilt")
}

android {
    namespace = "com.example.androidtemplate"

    defaultConfig {
        val propFile = file(rootProject.file("build.properties"))
        val properties = Properties().apply { load(FileInputStream(propFile)) }
        applicationId = "com.example.androidtemplate"
        versionCode = properties.getProperty("versionCode").toInt()
        versionName = properties.getProperty("versionName")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true

        }
        buildConfigField("int", "COMPILE_SDK", compileSdk.toString())
        buildConfigField("int", "TARGET_SDK", targetSdk.toString())
        buildConfigField("int", "MIN_SDK", minSdk.toString())
    }
    signingConfigs {
        getByName("debug") {
            keyAlias = "androiddebugkey"
            keyPassword = "android"
            storeFile = file(rootProject.file("debug.keystore"))
            storePassword = "android"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":feature:main"))
    implementation(project(":core:common"))
    implementation(project(":core:designsystem"))
    implementation(project(":timber"))

    debugImplementation(libs.androidx.compose.ui.testManifest)

    implementation(libs.accompanist.systemuicontroller)
    implementation(libs.accompanist.navigation.animation)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.compose.runtime.tracing)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.window.manager)
    implementation(libs.androidx.profileinstaller)
}