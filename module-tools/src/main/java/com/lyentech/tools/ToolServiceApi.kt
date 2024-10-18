package com.lyentech.tools

import android.app.AlertDialog
import android.content.Context
import com.lyentech.basic.utils.printD
import com.lyentech.bridge.IToolsService

/**
 * @author by jason-何伟杰，2024/10/18
 * des:tools组件对外暴露接口
 */
class ToolServiceApi : IToolsService {
    override fun showMedia(url: String?,context: Context) {
        printD("showMedia>$url")

        AlertDialog.Builder(context)
            .setMessage(url+"")
            .show()

    }
}