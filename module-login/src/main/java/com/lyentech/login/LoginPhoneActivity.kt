package com.lyentech.login

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.didi.drouter.annotation.Router
import com.didi.drouter.api.DRouter
import com.lyentech.basic.base.BaseGActivity
import com.lyentech.basic.base.bindView
import com.lyentech.basic.base.clickFilter
import com.lyentech.basic.base.delayTask
import com.lyentech.bridge.ModuleFactory
import com.lyentech.bridge.RoutePath

@Router(path = RoutePath.LOGIN_PHONE)
class LoginPhoneActivity : BaseGActivity() {
    private lateinit var btnLogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_phone)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnLogin = bindView(R.id.btnLogin)
        clickFilter(R.id.btnLogin) {
            btnLogin.text = "click"

            //调用另外Tools组件的api显示
            val url = "https://malloss.gree.com/gree-mall-v2/cc06e180c9004c85acd309128d18ff81.jpg"
            ModuleFactory.instance.getToolService()?.showMedia(url,this)

            delayTask {
                DRouter.build(RoutePath.TOOLS_PLAY).start()
            }
        }
    }
}