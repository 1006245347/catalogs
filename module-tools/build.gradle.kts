plugins {
    id("com.android.library")
}
// 使用自定义插件 业务组件插件
apply<ModuleGradlePlugin>()
android {
    namespace = "com.lyentech.tools"

}

dependencies {
    implementation(project(":coreLib:lib-basic"))

    //添加图片处理功能
    implementation(project(":coreLib:lib-media"))
}