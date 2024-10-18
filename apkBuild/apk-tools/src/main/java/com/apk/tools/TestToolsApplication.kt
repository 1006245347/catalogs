package com.apk.tools

import android.content.Context
import com.lyentech.basic.base.CoreApplicationProvider
import com.lyentech.basic.base.ModuleInitDelegate
import com.lyentech.tools.ModuleInitTools
/**
 * @author by jason-何伟杰，2024/10/18
 * des:独立apk运行，初始化sdk运行application
 */
class TestToolsApplication : CoreApplicationProvider() {
    init {
        ModuleInitDelegate.register(ModuleInitTools())
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}