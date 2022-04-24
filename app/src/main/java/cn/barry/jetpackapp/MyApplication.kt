package cn.barry.jetpackapp

import android.app.Application
import cn.barry.base.BaseApp
import cn.barry.jetpackapp.koin.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/*************************
 * @ProjectName: JetpackApp
 * @Dir_Path: app/src/main/java/cn/barry/jetpackapp
 * @Time: 2022/2/21 0:39
 * @Author: BarryAllen
 * @Description: 全局App
 **************************/


class MyApplication : BaseApp() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
//            androidLogger()
            androidContext(this@MyApplication)
            modules(appModule) //
        }
    }
}

