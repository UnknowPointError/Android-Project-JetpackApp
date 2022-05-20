package cn.barry.jetpackapp.app

import com.barry.base.BuildConfig
import com.barry.base.app.appContext
import com.barry.base.network.FlowCallAdapterFactory
import cn.barry.jetpackapp.baiduimage.BaiduImageConfig
import com.android.volley.toolbox.Volley
import cn.barry.jetpackapp.minebbs.MinebbsConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/*************************
 * @Machine: RedmiBook Pro 15 Win11
 * @Path: app/src/main/java/cn/barry/jetpackapp/app
 * @Time: 2022/5/20 12:56
 * @Author: BarryAllen
 * @Description: NetWorkModule
 **************************/

val netWorkModule = module {
    single {
        OkHttpClient.Builder().apply {
            addInterceptor(HttpLoggingInterceptor().also { interceptor ->
                interceptor.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                else HttpLoggingInterceptor.Level.NONE
            })
            pingInterval(5, TimeUnit.SECONDS)
            connectTimeout(5, TimeUnit.SECONDS)
            callTimeout(5, TimeUnit.SECONDS)
            readTimeout(5, TimeUnit.SECONDS)
            writeTimeout(5, TimeUnit.SECONDS)
            retryOnConnectionFailure(false)
        }.build()
    }
    single<Retrofit>(qualifier = named("RetrofitMinebbs")) {
        Retrofit.Builder()
            .baseUrl(MinebbsConfig.URL)
            .client(get())
            .addCallAdapterFactory(FlowCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single<Retrofit>(qualifier = named("RetrofitBaiduImage")) {
        Retrofit.Builder()
            .baseUrl(BaiduImageConfig.URL)
            .client(get())
            .addCallAdapterFactory(FlowCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single {
        Volley.newRequestQueue(appContext)
    }
}