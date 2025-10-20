import deps.androidx
import deps.hilt
import deps.room
import deps.testDebugDeps
import deps.testDeps
import deps.testImplDeps

plugins {
    id(plugs.BuildPlugins.ANDROID_LIBRARY)
}

android {
    namespace = "com.minafarid.login"

    apply<plugs.SharedLibraryGradlePlugin>()
}
dependencies {
    androidx()
    hilt()
    room()
    testDeps()
    testImplDeps()
    testDebugDeps()
}