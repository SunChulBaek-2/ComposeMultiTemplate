/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

plugins {
    `kotlin-dsl`
}

group = "kr.pe.ssun.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = "kr.pe.ssun.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidApplication") {
            id = "kr.pe.ssun.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
//        register("androidApplicationJacoco") {
//            id = "kr.pe.ssun.application.jacoco"
//            implementationClass = "AndroidApplicationJacocoConventionPlugin"
//        }
//        register("androidLibraryCompose") {
//            id = "kr.pe.ssun.library.compose"
//            implementationClass = "AndroidLibraryComposeConventionPlugin"
//        }
//        register("androidLibrary") {
//            id = "kr.pe.ssun.library"
//            implementationClass = "AndroidLibraryConventionPlugin"
//        }
//        register("androidFeature") {
//            id = "kr.pe.ssun.feature"
//            implementationClass = "AndroidFeatureConventionPlugin"
//        }
//        register("androidLibraryJacoco") {
//            id = "kr.pe.ssun.library.jacoco"
//            implementationClass = "AndroidLibraryJacocoConventionPlugin"
//        }
//        register("androidTest") {
//            id = "kr.pe.ssun.test"
//            implementationClass = "AndroidTestConventionPlugin"
//        }
//        register("androidHilt") {
//            id = "kr.pe.ssun.hilt"
//            implementationClass = "AndroidHiltConventionPlugin"
//        }
//        register("firebase-perf") {
//            id = "ssun.firebase-perf"
//            implementationClass = "FirebasePerfConventionPlugin"
//        }
    }
}
