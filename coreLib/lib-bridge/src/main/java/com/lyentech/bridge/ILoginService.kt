package com.lyentech.bridge

/**
 * @author by jason-何伟杰，2024/10/18
 * des:登录组件对外暴露的数据通信 Api
 */
interface ILoginService {

    fun getLoginToken(): String?

    fun getAdLink(): String
}