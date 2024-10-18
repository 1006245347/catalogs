import org.gradle.api.artifacts.dsl.DependencyHandler

/**
 *
 * 通过扩展函数的方式导入功能模块的全部依赖
 * 可以自行随意添加或更改
 * DefaultGradlePlugin统一对Library添加了依赖，更便捷
 */
fun DependencyHandler.appcompat() {
    api(DepManager.appcompat)
    api(DepManager.coreKtx)
    api(DepManager.activityKtx)
    api(DepManager.fragmentKtx)
    api(DepManager.multidex)
    api(DepManager.documentFile)
    api(DepManager.permissionCore)
    api(DepManager.mmkv)
}

//常用的布局控件
fun DependencyHandler.widgetLayout() {
    api(DepManager.constraintLayout)
    api(DepManager.recyclerView)
    api(DepManager.rvHelper)
    api(DepManager.material)
    api(DepManager.swipeRefresh)
}

//生命周期监听
fun DependencyHandler.lifecycle() {
    api(DepManager.Lifecycle.liveDataKtx)
    api(DepManager.Lifecycle.runtimeKtx)
    api(DepManager.Lifecycle.viewModelKtx)
}

//Kotlin与协程
fun DependencyHandler.kotlin() {

}

//测试Test依赖
fun DependencyHandler.test() {
    testImplementation(DepManager.junit)
    androidTestImplementation(DepManager.androidJunit)
    androidTestImplementation(DepManager.espresso)
    implementation(DepManager.buglySdk)
}

//滴滴路由 //https://github.com/didi/DRouter
fun DependencyHandler.router() {
    api(DepManager.routerCore)
    api(DepManager.routePage)
}

//Work任务
fun DependencyHandler.work() {
    api(DepManager.Work.runtime)
    api(DepManager.Work.runtime_ktx)
}

//exoplayer播放器，可边播边存
fun DependencyHandler.media3() {
    implementation(DepManager.Media3.exoplayer)
    implementation(DepManager.Media3.dash)
    implementation(DepManager.Media3.ui)
}

//网络请求
fun DependencyHandler.retrofit() {
    api(DepManager.Retrofit.core)
    api(DepManager.Retrofit.gson)
    api(DepManager.Retrofit.okLog3)
    api(DepManager.Retrofit.okhttp3)
}

//图片加载
fun DependencyHandler.glide() {
    implementation(DepManager.Glide.core)
    implementation(DepManager.Glide.annotation)
    implementation(DepManager.Glide.http3)
    implementation(DepManager.Glide.transformations)
    implementation(DepManager.Glide.bigImageCore)
    kapt(DepManager.Glide.compiler)
}

//摄像头
fun DependencyHandler.camera2(){
    implementation(DepManager.Camera2.core)
    implementation(DepManager.Camera2.camera2)
    implementation(DepManager.Camera2.lifecycle)
    implementation(DepManager.Camera2.view)
}




