package cn.barry.jetpackapp.app

import cn.barry.jetpackapp.baiduimage.network.BaiduImageService
import cn.barry.jetpackapp.minebbs.network.ModelService
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

/*************************
 * @Machine: RedmiBook Pro 15 Win11
 * @Path: app/src/main/java/cn/barry/jetpackapp/app
 * @Time: 2022/5/20 12:56
 * @Author: BarryAllen
 * @Description: ServiceModule
 **************************/

val servicesModule = module {
    single { get<Retrofit>(qualifier = named("RetrofitMinebbs")).create(ModelService::class.java) }
    single { get<Retrofit>(qualifier = named("RetrofitBaiduImage")).create(BaiduImageService::class.java) }
}
