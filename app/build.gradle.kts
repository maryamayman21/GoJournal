plugins {
    id(plugs.BuildPlugins.ANDROID_APP)
    id(plugs.BuildPlugins.KOTLIN_ANDROID)
    id(plugs.BuildPlugins.ANDROID)
    kotlin(plugs.BuildPlugins.KAPT)
}

android {

    namespace = build.BuildConfig.APP_ID
    compileSdk = build.BuildConfig.COMPILE_SDK_VERSION

    defaultConfig {
        applicationId = build.BuildConfig.APP_ID
        minSdk = build.BuildConfig.MIN_SDK_VERSION
        targetSdk = build.BuildConfig.TARGET_SDK_VERSION
        versionCode = release.ReleaseConfig.VERSION_CODE
        versionName = release.ReleaseConfig.VERSION_NAME

        testInstrumentationRunner = test.TestBuildConfig.TEST_INSTRUMENTATION_RUNNER
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    flavorDimensions.add(build.BuildDimensions.STORE)
    flavorDimensions.add(build.BuildDimensions.APP)
    productFlavors {
        flavors.BuildFlavor.Google.create(this)
        flavors.BuildFlavor.Huawei.create(this)
        flavors.BuildFlavor.Premium.create(this)
        flavors.BuildFlavor.Free.create(this)
    }
    signingConfigs {

        signing.BuildSigning.Release(project).create(this)
        signing.BuildSigning.ReleaseExternalQa(project).create(this)
        signing.BuildSigning.Debug(project).create(this)
    }

    buildTypes {
        build.BuildCreator.Release(project).create(this).apply {
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName(signing.SigningTypes.RELEASE)
        }


        build.BuildCreator.Debug(project).create(this).apply {
            signingConfig = signingConfigs.getByName(signing.SigningTypes.DEBUG)
        }

        build.BuildCreator.ReleaseExternalQa(project).create(this).apply {
            signingConfig = signingConfigs.getByName(signing.SigningTypes.RELEASE_EXTERNAL_QA)
        }

    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(deps.Dependencies.ANDROIDX_CORE)
    implementation(deps.Dependencies.ANDROIDX_LIFECYCLE_RUNTIME_KTX)
    implementation(deps.Dependencies.ANDROIDX_ACTIVITY_COMPOSE)
    implementation(deps.Dependencies.ANDROIDX_UI)
    implementation(deps.Dependencies.ANDROIDX_UI_GRAPHICS)
    implementation(deps.Dependencies.ANDROIDX_UI_TOOLING_PREVIEW)
    implementation(deps.Dependencies.ANDROIDX_MATERIAL3)
    testImplementation(test.TestDependencies.ANDROIDX_JUNIT)
    androidTestImplementation(test.TestDependencies.ANDROIDX_JUNIT)
    androidTestImplementation(test.TestDependencies.ANDROIDX_ESPRESSO_CORE)
    androidTestImplementation(test.TestDependencies.ANDROIDX_COMPOSE_UI_TEST)
    debugImplementation(deps.Dependencies.ANDROIDX_UI_TOOLING_PREVIEW)
    debugImplementation(test.TestDependencies.ANDROIDX_COMPOSE_UI_TEST_MANIFEST)

}