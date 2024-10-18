plugins {
    id("com.android.application")
}

// 使用自定义插件
apply<DefaultGradlePlugin>()
android {
    namespace = "com.apk.tools"
}

dependencies {
//    implementation(project(":coreLib:lib-basic"))
    implementation(project(":module-tools"))

    //甚至一起编译多个子module也行的
//    implementation(project(":module-login"))
}