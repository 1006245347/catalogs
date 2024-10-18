/**
 *
 * 项目编译配置与AppId配置
 */
object ProjectConfig {
    const val minSdk = 21
    const val compileSdk = 34
    const val targetSdk = 33

    const val versionCode = 100
    const val versionName = "1.0.0"

    const val applicationId = "com.lyentech.cn"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

}

//签名文件信息配置
object SigningConfigs {
    //密钥文件路径
    const val store_file = "key/appkeystore.jks"

    //密钥密码
    const val store_password = "123456"

    //密钥别名
    const val key_alias = "jason"

    //别名密码
    const val key_password = "123456"
}