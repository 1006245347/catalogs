package com.lyentech.bridge

/**
 * @author by jason-何伟杰，2024/10/18
 * des:统一管理module的通信,禁止外部创建 ModuleFactory对象
 */
class ModuleFactory private constructor() {

    //登录组件的对外接口
    private var loginService: ILoginService? = null


    //工具组件的对外接口
    private var toolService: IToolsService? = null

    companion object {
        //单例设计
        val instance: ModuleFactory by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            ModuleFactory()
        }
    }

    fun setLoginService(service: ILoginService) {
        this.loginService = service
    }

    fun getLoginService(): ILoginService? {
        return loginService
    }

    fun setToolService(service: IToolsService?) {
        this.toolService = service
    }

    fun getToolService(): IToolsService? {
        if (null == toolService) {
//            toolService= EmptyModuleService()
        }
        return toolService
    }
}