plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.ksp)
    alias(libs.plugins.compose)
    alias(libs.plugins.kotlinSerialization)
    id ("dev.icerock.mobile.multiplatform-resources")
//    alias(libs.plugins.multiplatformResources)
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()
    android() {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            export("dev.icerock.moko:resources:0.23.0")
            export("dev.icerock.moko:graphics:0.9.0") // toUIColor here
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                //Compose
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
                //Koin
                implementation(libs.koin.core)
                implementation(libs.koin.compose)

                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.serialization)
                implementation(libs.ktor.client.content.negotiation)//converts response to dto object
                implementation(libs.ktor.serialization.kotlinx.json)
                implementation(libs.ktor.client.logging)// enable http logging

                // kotlin-inject runtime
                implementation(libs.kotlinInject.runtime)

                //moko
                api(libs.moko.mvvm.core)
                api(libs.moko.mvvm.compose)
                api(libs.moko.mvvm.flow)
                api(libs.moko.mvvm.flow.compose)
                api(libs.moko.mvvm.flow.resources)
                api(libs.moko.resources)
                api(libs.moko.resources.compose)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.koin.android)
                implementation(libs.ktor.client.android)
            }
            this.dependsOn(commonMain)
        }

        val iosX64Main by getting
        val iosArm64Main by getting
        val iosMain by getting {
            dependencies {
                implementation(libs.ktor.client.ios)
            }
            this.dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
        }
    }
}

android {
    namespace = "com.example.kmmtest"
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    add("kspIosX64", libs.kotlinInject.compiler)
    add("kspIosArm64", libs.kotlinInject.compiler)
    add("kspIosSimulatorArm64", libs.kotlinInject.compiler)
    //add("kspCommonMainMetadata", libs.kotlinInject.compiler)
    add("kspAndroid", libs.kotlinInject.compiler)
}
multiplatformResources {
    multiplatformResourcesPackage = "com.example.kmmtest"     // required
}