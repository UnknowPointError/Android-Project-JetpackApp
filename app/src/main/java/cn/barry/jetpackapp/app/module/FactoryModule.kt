package cn.barry.jetpackapp.app

import cn.barry.jetpackapp.baiduimage.model.BaiduImageRepository
import cn.barry.jetpackapp.koin.KoinBaseInterface
import cn.barry.jetpackapp.koin.KoinRepository
import cn.barry.jetpackapp.minebbs.model.MinebbsRepository
import org.koin.dsl.module

/*************************
 * @Machine: RedmiBook Pro 15 Win11
 * @Path: app/src/main/java/cn/barry/jetpackapp/app
 * @Time: 2022/5/20 12:55
 * @Author: BarryAllen
 * @Description: FactoryModule
 **************************/

val factoryModule = module {
    factory {
        KoinRepository(object : KoinBaseInterface {
            override fun sayHello(): String = "Hello"
        })
    }
    factory { MinebbsRepository(get()) }
    factory { BaiduImageRepository(get()) }
}