package cn.barry.jetpackapp

import cn.barry.base.BaseApp
import cn.barry.jetpackapp.koin.*
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

/*************************
 * @ProjectName: JetpackApp
 * @Dir_Path: app/src/main/java/cn/barry/jetpackapp
 * @Time: 2022/2/21 0:39
 * @Author: BarryAllen
 * @Description: 全局App
 **************************/

private val appModule = module {

    factory<KoinRepository> {
        KoinRepository(object : KoinBaseInterface {
            override fun sayHello(): String = "Hello"
        })
    }

    viewModel { KoinViewModel(get()) }
}

class JetPackApplication : BaseApp() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@JetPackApplication)
            modules(appModule)
        }
    }
}

