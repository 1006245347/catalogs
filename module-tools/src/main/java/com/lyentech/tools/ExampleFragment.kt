package com.lyentech.tools

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.fragment.app.Fragment
import com.didi.drouter.annotation.Router
import com.didi.drouter.api.DRouter
import com.didi.drouter.utils.RouterLogger
import com.lyentech.basic.utils.printD
import com.lyentech.bridge.RoutePath

@Router(path = RoutePath.TOOLS_EX) //scheme="didi",host="router",
class ExampleFragment : Fragment() {

    private lateinit var launcher: ActivityResultLauncher<Intent>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val data = arguments?.getString("ex")
        printD("data>$data")

        launcher = registerForActivityResult(object : ActivityResultContract<Intent, String?>() {
            override fun createIntent(context: Context, input: Intent): Intent {
                val bundle = Bundle()
                bundle.putString("key", "China")
                input.putExtra("data", bundle)
                return input
            }

            override fun parseResult(resultCode: Int, intent: Intent?): String? {
                if (intent != null) {
//                    val msg =intent.getStringExtra("")
                    val msg = intent.getBundleExtra("back")?.getString("key")
                    return msg
                } else {
                    return null
                }
            }
        }, object : ActivityResultCallback<String?> {
            override fun onActivityResult(result: String?) {
                printD("result2>$result")
            }
        }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_ex, container, false)
        view.findViewById<Button>(R.id.btnEx).setOnClickListener {
            DRouter.build(RoutePath.TOOLS_PLAY).setActivityResultLauncher(launcher)
                .start(context)
        }
        return view
    }
}