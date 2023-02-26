package com.lee.culturalplanner

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.pm.ActivityInfo
import android.os.Bundle

/**
 * 최초 실행코드
 * App scope class,file 에서 호출할수있는 코드
 */
class CulturalPlannerApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        appInstance = this
        settingScreenPortrait()
    }
    companion object{
        private lateinit var appInstance: CulturalPlannerApplication
        fun getAppInstance() = appInstance
    }
    private fun settingScreenPortrait(){
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            @SuppressLint("SourceLockedOrientationActivity")
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            }
            // 모든 activity 에서 재정의 해야할 부분 있을시
            override fun onActivityStarted(activity: Activity) {}
            override fun onActivityResumed(activity: Activity) {}
            override fun onActivityPaused(activity: Activity) {}
            override fun onActivityStopped(activity: Activity) {}
            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
            override fun onActivityDestroyed(activity: Activity) {}
        })
    }
}