plugins {
    id("com.android.application")

}

// 使用自定义插件
apply<DefaultGradlePlugin>()

android {
    namespace = "com.apk.login"
}

dependencies {

    //依赖子组件
    implementation(project(":module-login"))
}