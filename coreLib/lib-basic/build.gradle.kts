plugins {
    id("com.android.library")

}
// 使用自定义插件
apply<DefaultGradlePlugin>()

android {
    namespace = "com.lyentech.basic"
}

//所有module都用到依赖,setProjectConfigByLibrary有公共的
dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar", "*.aar"))))
}