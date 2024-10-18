package com.apk.login

import android.content.Context
import com.lyentech.basic.base.CoreApplicationProvider
import com.lyentech.basic.base.ModuleInitDelegate
import com.lyentech.login.ModuleInitLogin

/**
 * @author by jason-何伟杰，2024/10/18
 * des:独立apk运行，初始化sdk运行application
 */
class TestLoginApplication : CoreApplicationProvider() {

    init {
        ModuleInitDelegate.register(ModuleInitLogin())
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