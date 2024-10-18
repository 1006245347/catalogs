package com.lyentech.cn

import com.lyentech.basic.base.CoreApplicationProvider
import com.lyentech.basic.base.ModuleInitDelegate
import com.lyentech.login.ModuleInitLogin
import com.lyentech.tools.ModuleInitTools

/**
 * @author by jason-何伟杰，2024/10/18
 * des:壳 模块app 不应存在任何代码类，只提供个上下文管理
 * apps上线集成要引用init{}的代码
 */
class CBApp : CoreApplicationProvider() {

    init {
        ModuleInitDelegate.register(ModuleInitLogin(), ModuleInitTools())
    }
}