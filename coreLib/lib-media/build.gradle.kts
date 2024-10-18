plugins {
    id("com.android.library")
}
// 使用自定义插件
apply<DefaultGradlePlugin>()

android {
    namespace = "com.lyentech.media"
}

//一般图片、视频、摄像头库都比较大，并且不一定每个module都用到，抽出独立
dependencies {
    glide()
//    media3()
//    camera2()
}