package com.lyentech.login

import com.lyentech.basic.base.BaseModuleInit
import com.lyentech.basic.utils.printD
import com.lyentech.bridge.ModuleFactory

/**
 * @author by jason-何伟杰，2024/10/18
 * des:每个子组件内部不声明application,但是封装
 */
class ModuleInitLogin :BaseModuleInit(){

    override fun onCreate() {
        super.onCreate()

        printD("init sdk login>")
        ModuleFactory.instance.setLoginService(LoginServiceApi())
    }

    override val priority: Int
        get() = 0
}