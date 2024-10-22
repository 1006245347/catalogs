package com.lyentech.login

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.media.MediaRouter2.RouteCallback
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContract
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.didi.drouter.annotation.Router
import com.didi.drouter.api.DRouter
import com.didi.drouter.api.Extend
import com.didi.drouter.router.Result
import com.didi.drouter.router.RouterCallback
import com.lyentech.basic.base.BaseGActivity
import com.lyentech.basic.base.bindView
import com.lyentech.basic.base.clickFilter
import com.lyentech.basic.base.delayTask
import com.lyentech.basic.utils.printD
import com.lyentech.bridge.ModuleFactory
import com.lyentech.bridge.RoutePath

@Router(path = RoutePath.LOGIN_PHONE)
class LoginPhoneActivity : BaseGActivity() {
    private lateinit var btnLogin: TextView
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
            ModuleFactory.instance.getToolService()?.showMedia(url, this)

            delayTask {
//                DRouter.build(RoutePath.TOOLS_PLAY).start()
                DRouter.build(RoutePath.TOOLS_PLAY)
                    .setActivityResultLauncher(launcher)
                    .start()
            }
        }

        clickFilter(R.id.btnEx) {
            DRouter.build( RoutePath.TOOLS_EX)//"didi://router"
                .putExtra("ex", "333")
//                .putExtra(
//                    Extend.START_ACTIVITY_FLAGS,
//                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//                )
                .start(LoginPhoneActivity@ this, object : RouterCallback {
                    override fun onResult(result: Result) {
                        result.fragment?.let {
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.fragment_container_view, it)
                                .commit()
                        }
                    }
                })
        }
    }

    private val launcher =
        registerForActivityResult(object : ActivityResultContract<Intent, String?>() {
            override fun createIntent(context: Context, input: Intent): Intent {
                val bundle = Bundle()
                bundle.putString("key", "China")
                input.putExtra("data", bundle)
                return input
            }

            override fun parseResult(resultCode: Int, intent: Intent?): String {
                if (null == intent) {
                    return ""
                } else {
                    if (resultCode == Activity.RESULT_OK) {
                        val data = intent.getBundleExtra("back")
                        val result = data?.getString("key")
                        return result!!
                    }
                }
                return "null"
            }
        },
            object : ActivityResultCallback<String?> {
                override fun onActivityResult(result: String?) {
                    printD("out>$result")
                }
            })
}