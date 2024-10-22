package com.lyentech.basic.base

import android.app.Application
import android.content.Context
import android.os.Build
import android.os.Environment
import com.didi.drouter.api.DRouter
import com.lyentech.basic.utils.printV
import java.io.File

/**
 * @author by jason-何伟杰，2022/12/8
 * des:共享Application
 */
open class CoreApplicationProvider : Application() {
    companion object {
        // 全局共享的 Application
        lateinit var appContext: Application
        val SAVE_DIR = Environment.DIRECTORY_DCIM

        /****私有目录，卸载被删除*****/

        //预览文件（图片、视频、文档）-都是要先下载好，先放私有目录，使用时复制到共有，不同账号数据隔离
        @JvmStatic
        fun getUserCacheDir(): File? {
            return appContext.getExternalFilesDir("file_cache")
        }

        //如果每次同链接都下载都这，然后要下载时复制到共有目录
        @JvmStatic
        fun getDownLoadDir(): File? {
//            return appContext.getExternalFilesDir("ark_downLoad") //外部存储的私有目录 还是可以对外看见
            return File(appContext.filesDir.absolutePath + File.separator + "ark_download") //内部存储，手机也无法看见
        }

        @JvmStatic
        fun getUserDownLoadDir(userId: Long): File? {
            return appContext.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS + "/" + userId)
        }

        /****公有目录，要权限  目前所有的手动下载都到这里，允许重复下载****/
        @JvmStatic
        fun getGlobalDir(userId: Long = 0): String {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {//android10开始分区存储
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).absolutePath + File.separator + "ark_download" + File.separator + userId + File.separator
            } else {
                Environment.getExternalStorageDirectory().absolutePath + File.separator + "ark_download" + File.separator + userId + File.separator
            }
        }

        /** 文件到图册*/
        @JvmStatic
        fun getDevDCIM(userid: Long = 0, isCopy: Boolean = false): String {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                if (isCopy) {
//                    if (isHarmonyOs()) { //临时缓存文件夹，Android10后是先下载到外部再复制到图册,鸿蒙必须是应用内部再复制，这里特意分开不然不容易发现
                    getUserDownLoadDir(userid)?.absolutePath + ""
//                    } else {
//                        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).absolutePath + File.separator + "ark_download" + File.separator + userid + File.separator
//                    }
                } else {
                    Environment.getExternalStorageDirectory().absolutePath + File.separator + SAVE_DIR + File.separator + "ark_download" + File.separator + userid + File.separator
                }
            } else {
                Environment.getExternalStoragePublicDirectory(SAVE_DIR).absolutePath + File.separator + "ark_download" + File.separator + userid + File.separator
            }
        }


    }


    override fun onCreate() {
        super.onCreate()
        if (isAppMainProcess(this)) {
            appContext = this
            initApp()//确保只在主进程初始化
            ModuleInitDelegate.reorder()
            ModuleInitDelegate.onCreate()
        }
        printV("Application执行次数》》 $this")
    }

    /*模块的初始化保证在主进程中*/
    private fun isAppMainProcess(context: Context): Boolean {
//        if (TextUtils.equals(getCurProcessName(context), packageName)) {
        return true
//        }
//        return false
    }

    /*适合基础库的初始化，会回调到所有模块*/
    open fun initApp() {
        DRouter.init(this) //初始化路由表
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
//        MultiDex.install(base)
        if (isAppMainProcess(this)) {
            ModuleInitDelegate.attachBaseContext(base)
        }
    }

    override fun onLowMemory() {
        super.onLowMemory()
        ModuleInitDelegate.onLowMemory()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        ModuleInitDelegate.onTrimMemory(level)
    }

    override fun onTerminate() {
        super.onTerminate()
        ModuleInitDelegate.onTerminate()
    }
}