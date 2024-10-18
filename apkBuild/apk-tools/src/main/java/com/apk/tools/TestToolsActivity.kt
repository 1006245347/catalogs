package com.apk.tools

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.didi.drouter.api.DRouter
import com.lyentech.basic.base.clickFilter
import com.lyentech.bridge.RoutePath

class TestToolsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_test_tools)
        clickFilter(R.id.btnTest) {
            DRouter.build(RoutePath.TOOLS_PLAY).start()
        }
    }
}