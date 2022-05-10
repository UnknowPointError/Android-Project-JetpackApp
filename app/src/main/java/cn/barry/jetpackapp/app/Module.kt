package cn.barry.jetpackapp.app

import cn.barry.base.BuildConfig
import cn.barry.base.app.appContext
import cn.barry.base.network.FlowCallAdapterFactory
import cn.barry.jetpackapp.customview.CustomViewViewModel
import cn.barry.jetpackapp.koin.KoinBaseInterface
import cn.barry.jetpackapp.koin.KoinRepository
import cn.barry.jetpackapp.koin.KoinViewModel
import cn.barry.jetpackapp.pixabay.view.PixabayViewModel
import com.android.volley.toolbox.Volley
import com.barry.minebbs.view.activity.MinebbsViewModel
import com.barry.minebbs.MinebbsConfig
import com.barry.minebbs.model.MinebbsRepository
import com.barry.minebbs.network.ModelService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Module {

    val repositoryModule = module {
        factory {
            KoinRepository(object : KoinBaseInterface {
                override fun sayHello(): String = "Hello"
            })
        }
        factory { MinebbsRepository(get()) }
    }

    val viewModelModule = module {
        viewModel { KoinViewModel(get()) }
        viewModel { MinebbsViewModel(get()) }
        viewModel { PixabayViewModel(get()) }
        viewModel { CustomViewViewModel() }
    }

    val netWorkModule = module {
        single {
            OkHttpClient.Builder().apply {
                val httpLoggingInterceptor = HttpLoggingInterceptor().also {
                    it.level =
                        if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                        else HttpLoggingInterceptor.Level.NONE
                }
                connectTimeout(5, TimeUnit.SECONDS)
                readTimeout(5, TimeUnit.SECONDS)
                writeTimeout(5, TimeUnit.SECONDS)
                addNetworkInterceptor(httpLoggingInterceptor)
            }.build()
        }
        single {
            Retrofit.Builder()
                .baseUrl(MinebbsConfig.Base_Url)
                .client(get())
                .addCallAdapterFactory(FlowCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        single {
            Volley.newRequestQueue(appContext)
        }
    }

    val servicesModule = module {
        single {
            get<Retrofit>().create(ModelService::class.java)
        }
    }
}
