package cn.barry.jetpackapp.app

import com.barry.base.app.BaseApp
import com.barry.base.app.BaseAppException
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/*************************
 * @ProjectName: JetpackApp
 * @Dir_Path: app/src/main/java/cn/barry/jetpackapp
 * @Time: 2022/2/21 0:39
 * @Author: BarryAllen
 * @Description: 全局App
 **************************/

class JetpackApp : BaseApp() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@JetpackApp)
            modules(listOf(netWorkModule, servicesModule, viewModelModule, factoryModule))
        }
        Thread.setDefaultUncaughtExceptionHandler(BaseAppException())
    }
}

