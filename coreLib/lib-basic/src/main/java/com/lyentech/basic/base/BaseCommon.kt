package com.lyentech.basic.base

import android.content.Intent
import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.chad.library.adapter.base.BaseQuickAdapter
import com.didi.drouter.api.DRouter
import com.didi.drouter.api.Extend
import com.lyentech.basic.R
import kotlinx.coroutines.*
import org.json.JSONObject

/**
 * @author by jason-何伟杰，2022/12/19
 * des:只有AppCompatActivity有实现各类周期函数监听功能
 */
internal val curLifeScopeTaskMap = hashMapOf<Int, Job>()

/*Activity作用域下可控的延迟任务*/
fun FragmentActivity.delayTask(
    defaultDispatcher: CoroutineDispatcher =
        Dispatchers.Main,
    mills: Long = 1000L,
    cancelTag: Int = 1,
    block: suspend CoroutineScope.() -> Unit
) {
    val job = lifecycleScope.launch(defaultDispatcher) {
        delay(mills)
        block()
    }
    curLifeScopeTaskMap[cancelTag] = job //setTag
}

fun FragmentActivity.task(
    defaultDispatcher: CoroutineDispatcher =
        Dispatchers.Default, cancelTag: Int = 1,
    block: suspend CoroutineScope.() -> Unit
) {
    val job = lifecycleScope.launch(defaultDispatcher) { block() }
    curLifeScopeTaskMap[cancelTag] = job
}

fun FragmentActivity.uiTask(
    defaultDispatcher: CoroutineDispatcher =
        Dispatchers.Main, cancelTag: Int = 4,
    block: suspend CoroutineScope.() -> Unit
) {
    val job = lifecycleScope.launch(defaultDispatcher) { block() }
    curLifeScopeTaskMap[cancelTag] = job
}

/*会把 lifecycleScope整个协程域相关的任务都停止*/
fun FragmentActivity.cancelDelay(cancelTag: Int = 1) {
    val job = curLifeScopeTaskMap[cancelTag]
    job?.cancel()
}

fun FragmentActivity.launchAty(path: String) {
    DRouter.build(path).putExtra(Extend.START_ACTIVITY_FLAGS, Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_SINGLE_TOP).start()
}

/**过滤重复点击*/
fun FragmentActivity.clickFilter(@IdRes id: Int, mills: Long = 500, block: () -> Unit) {
    findViewById<View>(id).clickFilter(mills) { block() }
}

/**
 * get set
 * 给view添加一个上次触发时间的属性（用来屏蔽连击操作）
 */
private var <T : View>T.triggerLastTime: Long
    get() = if (getTag(R.id.triggerLastTimeKey) != null) getTag(R.id.triggerLastTimeKey) as Long else 0
    set(value) {
        setTag(R.id.triggerLastTimeKey, value)
    }

/**
 * get set
 * 给view添加一个延迟的属性（用来屏蔽连击操作）
 */
private var <T : View> T.triggerDelay: Long
    get() = if (getTag(R.id.triggerDelayKey) != null) getTag(R.id.triggerDelayKey) as Long else -1
    set(value) {
        setTag(R.id.triggerDelayKey, value)
    }

/**
 * 判断时间是否满足再次点击的要求（控制点击）
 */
private fun <T : View> T.clickEnable(): Boolean {
    var clickable = false
    val currentClickTime = System.currentTimeMillis()
    if (currentClickTime - triggerLastTime >= triggerDelay) {
        clickable = true
    }
    triggerLastTime = currentClickTime
    return clickable
}
/***
 * 带延迟过滤点击事件的 View 扩展
 * @param delay Long 延迟时间，默认500毫秒
 * @param block: (T) -> Unit 函数
 * @return Unit
 */
//@JvmStatic
fun <T : View> T.clickFilter(delay: Long = 500, block: (T) -> Unit) {
    triggerDelay = delay
    setOnClickListener {
        if (clickEnable()) {
            block(this)
        }
    }
}

fun <T : View> FragmentActivity.bindView(@IdRes id: Int): T {
    return findViewById<T>(id)
}

fun ViewModel.delayTask(
    defaultDispatcher: CoroutineDispatcher =
        Dispatchers.Default,
    mills: Long = 2000L,
    cancelTag: Int = 1,
    block: suspend CoroutineScope.() -> Unit
) {
    val job = viewModelScope.launch(defaultDispatcher) {
        delay(mills)
        block()
    }
    curLifeScopeTaskMap[cancelTag] = job //setTag
}

fun ViewModel.cancelDelay(cancelTag: Int = 1) {
    val job = curLifeScopeTaskMap[cancelTag]
    job?.cancel()
}

fun FragmentActivity.toast(text: String) {
    lifecycleScope.launch(Dispatchers.Main) {
//        UiHelper.toast(this@toast, text)
    }
}

fun Fragment.toast(text: String) {
    lifecycleScope.launch(Dispatchers.Main) {
//        UiHelper.toast(text = text)
    }
}

fun BaseQuickAdapter<*, *>.setNewList(list: Collection<Any>?) {
    submitList(list as List<Nothing>)
}

fun BaseQuickAdapter<*, *>.addList(list: Collection<Any>?) {
    addAll(list as List<Nothing>)
}

fun JSONObject.toStr():String{
   return this.toString().replace("\\","")
}



