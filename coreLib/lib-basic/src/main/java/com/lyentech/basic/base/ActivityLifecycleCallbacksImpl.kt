package com.lyentech.basic.base

import android.app.Activity
import android.app.Application
import android.os.Bundle


/**
 * @author by jason-何伟杰，2022/9/30
 * des:监听所有Activity的生命周期变化,包括sdk三方库的Activity
 */
open class ActivityLifecycleCallbacksImpl : Application.ActivityLifecycleCallbacks {

    private var activityTopCount = 0
    override fun onActivityCreated(activity: Activity, p1: Bundle?) {
//        printD("onActivityCreated--$activity")
//        ActivityStackUtils.add(activity)
    }

    override fun onActivityStarted(activity: Activity) {
        activityTopCount++
//        printD("onActivityStarted--$activity $activityTopCount")
        //数值记录从0到1说明是从后台切到前台
        if (activityTopCount == 1) {
//            MMKVUtils.addBool(ArkConfig.APP_BACK_TO_TOP, true)
//            GlobalCode.askLockVerify(activity)
        }
    }

    override fun onActivityResumed(activity: Activity) {
//        printD("onActivityResumed--$activity")
    }

    override fun onActivityPaused(activity: Activity) {
//        printI("onActivityPaused--$activity")
    }

    override fun onActivityStopped(activity: Activity) {
//        printD("onActivityStopped--$activity")
        activityTopCount--
        //数值从1到0说明是前台切到后台
//        if (activityTopCount == 0) {
//            MMKVUtils.addLong(ArkConfig.DATA_LAST_FINGER, System.currentTimeMillis())
//        }
    }

    override fun onActivitySaveInstanceState(activity: Activity, p1: Bundle) {
    }

    override fun onActivityDestroyed(activity: Activity) {
//        printD("onActivityDestroyed--$activity")
//        ActivityStackUtils.del(activity)
    }
}

