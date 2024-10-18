package com.lyentech.basic.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyentech.basic.utils.printD

abstract class BaseGActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        printD("create>>$this")
    }
}