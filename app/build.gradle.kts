plugins {
    id("com.android.application")
}
// 使用自定义插件
apply<DefaultGradlePlugin>()
android {
    namespace = "com.lyentech.cn"

    defaultConfig {
        applicationId = ProjectConfig.applicationId
    }


//如果要配置 JPush、GooglePlay等配置，直接接下去写即可
}

dependencies {

    implementation(project(":module-login"))
    implementation(project(":module-tools"))
//    implementation(project(":coreLib:lib-basic"))
}