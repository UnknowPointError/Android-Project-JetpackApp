package cn.barry.base

import android.app.Application

/**
 * @Description: BaseApp
 * @author Barry
 * @date 2022/2/20 03:12 凌晨
 */

val appContext = BaseApp.context

open class BaseApp: Application() {
    companion object {
        lateinit var context: Application
    }

    override fun onCreate() {
        super.onCreate()
        context = this

    }
}