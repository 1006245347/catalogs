package com.lyentech.tools

import com.lyentech.basic.base.BaseModuleInit
import com.lyentech.basic.utils.printD
import com.lyentech.bridge.ModuleFactory

class ModuleInitTools:BaseModuleInit() {

    override fun onCreate() {
        super.onCreate()
        printD("init sdk tools>")
        ModuleFactory.instance.setToolService(ToolServiceApi())
    }

    override val priority: Int
        get() = 1
}