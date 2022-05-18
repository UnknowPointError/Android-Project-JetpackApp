package cn.barry.jetpackapp.app

import cn.barry.base.app.BaseApp
import cn.barry.base.app.BaseAppException
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
            with(Module) {
                androidContext(this@JetpackApp)
                modules(listOf(netWorkModule, servicesModule, viewModelModule, repositoryModule))
            }
        }
        Thread.setDefaultUncaughtExceptionHandler(BaseAppException())
    }
}

