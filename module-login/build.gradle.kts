plugins {
    id("com.android.library")

}
// 使用自定义插件 业务组件插件
apply<ModuleGradlePlugin>()

android {
    namespace = "com.lyentech.login"
}
dependencies {
    implementation(project(":coreLib:lib-basic"))

}