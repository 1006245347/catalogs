package com.lyentech.bridge

import android.content.Context

/**
 * @author by jason-何伟杰，2024/10/18
 * des:Tools组件对外暴露，提供组件间通信能力
 */
interface IToolsService {

    fun showMedia(url:String?,context: Context)

}