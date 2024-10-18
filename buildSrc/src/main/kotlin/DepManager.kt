/**
 * @author by jason-何伟杰，2024/10/17
 * des:对应依赖库版本
 */
object DepManager {

    const val appcompat = "androidx.appcompat:appcompat:1.6.1"

    //core包+ktx扩展函数
    const val coreKtx = "androidx.core:core-ktx:1.10.1"

    //activity+ktx扩展函数
    const val activityKtx = "androidx.activity:activity-ktx:1.8.0"

    //fragment+ktx扩展函数
    const val fragmentKtx = "androidx.fragment:fragment-ktx:1.5.1"

    //约束布局
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.4"

    //材料设计
    const val material = "com.google.android.material:material:1.11.0"

    //分包
    const val multidex = "androidx.multidex:multidex:2.0.1"

    //文档管理
    const val documentFile = "androidx.documentfile:documentfile:1.0.1"

    //滴滴路由框架
    const val routerCore = "io.github.didi:drouter-api:2.4.6"           // Router、Service
    const val routePage = "io.github.didi:drouter-api-page:1.0.0"      // Page

    //兼容之Android13权限
    const val permissionCore = "com.guolindev.permissionx:permissionx:1.8.0"  //已适配Android13

    //****************************************ui类**************************************

    //界面view  #4.0 https://github.com/CymChad/BaseRecyclerViewAdapterHelper/wiki/BaseMultiItemAdapter
    const val rvHelper = "io.github.cymchad:BaseRecyclerViewAdapterHelper:4.0.0-beta04"
    const val recyclerView = "androidx.recyclerview:recyclerview:1.3.0-rc01"
    const val swipeRefresh = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"


    object Lifecycle {
        private const val version = "2.7.0"
        const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
        const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
        const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
    }


    object Glide {
        private const val version = "4.14.2"
        const val core = "com.github.bumptech.glide:glide:$version"
        const val compiler = "com.github.bumptech.glide:compiler:$version"
        const val http3 = "com.github.bumptech.glide:okhttp3-integration:$version"
        const val transformations = "jp.wasabeef:glide-transformations:4.3.0"
        const val annotation = "androidx.annotation:annotation:1.5.0" //androidx注解迁移
        const val bigImageCore = "com.github.SherlockGougou:BigImageViewPager:androidx-7.1.4"
    }

    object Media3 {
        private const val version = "1.4.1"
        const val exoplayer = "androidx.media3:media3-exoplayer:$version"
        const val dash = "androidx.media3:media3-exoplayer-dash:$version"
        const val ui = "androidx.media3:media3-ui:$version"
    }

    object Camera2{
        private const val version = "1.2.0"

        const val camera2 = "androidx.camera:camera-camera2:$version"

        const val core = "androidx.camera:camera-core:$version"

        const val lifecycle = "androidx.camera:camera-lifecycle:$version"

        const val view = "androidx.camera:camera-view:$version"
    }

    //*****************************************data类*************************************
    //日志上报
    const val buglySdk = "com.tencent.bugly:crashreport:4.1.9"

    //内存存储
    const val mmkv = "com.tencent:mmkv:1.2.13"

    //Android 下载  https://github.com/coolerfall/Android-HttpDownloadManager
    const val downloadDep = "com.coolerfall:android-http-download-manager:2.0.0"

    //测试
    const val junit = "junit:junit:4.13.2"
    const val androidJunit = "androidx.test.ext:junit:1.1.5"
    const val espresso = "androidx.test.espresso:espresso-core:3.5.1"

    object Retrofit {
        private const val version = "2.9.0"
        private const val okhttp3_version = "4.9.3"
        const val core = "com.squareup.retrofit2:retrofit:$version"
        const val gson = "com.squareup.retrofit2:converter-gson:$version"
        const val okLog3 = "com.squareup.okhttp3:logging-interceptor:$okhttp3_version"
        const val okhttp3 = "com.squareup.okhttp3:okhttp:$okhttp3_version"
    }

    object Work {
        private const val version = "2.8.1"
        const val runtime = "androidx.work:work-runtime:$version"
        const val runtime_ktx = "androidx.work:work-runtime-ktx:$version"
    }
}