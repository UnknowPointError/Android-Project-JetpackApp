package cn.barry.jetpackapp.koin

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/*************************
 * @ProjectName: JetpackApp
 * @Dir_Path: app/src/main/java/cn/barry/jetpackapp
 * @Time: 2022/2/21 1:04
 * @Author: BarryAllen
 * @Description:
 **************************/
val appModule = module {
    single<HelloRepository> { HelloRepositoryImpl() }

    // Simple Presenter Factory
    factory {
        MySimplePresenter(get())
    }

    single {
        SingleClass()
    }

    // MyViewModel ViewModel
    viewModel { MyViewModel(get()) }
}