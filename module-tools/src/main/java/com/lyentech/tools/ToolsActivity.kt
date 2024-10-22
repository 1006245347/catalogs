package com.lyentech.tools

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.didi.drouter.annotation.Router
import com.lyentech.basic.base.BaseGActivity
import com.lyentech.basic.base.bindView
import com.lyentech.basic.base.clickFilter
import com.lyentech.basic.utils.printD
import com.lyentech.bridge.ModuleFactory
import com.lyentech.bridge.RoutePath
import com.lyentech.media.GlideUtils

@Router(path = RoutePath.TOOLS_PLAY)
class ToolsActivity : BaseGActivity() {

    private lateinit var ivPic: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tools)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        ivPic = bindView(R.id.ivPic)
        clickFilter(R.id.btnClick) {
            //这里获取其他组件数据，可以再建写函数包装一下，不然写的ModuleFactory.instance.getLoginService()?代码多
            val token = ModuleFactory.instance.getLoginService()?.getLoginToken()
            printD("$token")
            val url = ModuleFactory.instance.getLoginService()?.getAdLink()
            printD("$url")
            GlideUtils.loadImg(this, url, ivPic)  //注意网络、权限
        }

        clickFilter(R.id.btnBack) {
            val intent = getIntent()
            val bundle = Bundle()
            bundle.putString("key", "返回222")
            intent.putExtra("back", bundle)
            setResult(RESULT_OK, intent)
            finish()
        }

        val msg= intent.getBundleExtra("data")?.getString("key")
        printD("msg>$msg")
    }
}