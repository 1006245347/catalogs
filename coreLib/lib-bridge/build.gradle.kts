plugins {
    id("com.android.library")
}
// 使用自定义插件
apply<DefaultGradlePlugin>()
android {
    namespace = "com.lyentech.bridge"
}

//组件间通信，其实都是接口，类似Arouter的IProvider
dependencies {

}