package cn.barry.jetpackapp.app

import cn.barry.jetpackapp.baiduimage.view.activity.BaiduImageNavigationViewModel
import cn.barry.jetpackapp.customview.CustomViewViewModel
import cn.barry.jetpackapp.koin.KoinViewModel
import cn.barry.jetpackapp.pixabay.view.PixabayViewModel
import cn.barry.jetpackapp.minebbs.view.activity.MinebbsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/*************************
 * @Machine: RedmiBook Pro 15 Win11
 * @Path: app/src/main/java/cn/barry/jetpackapp/app
 * @Time: 2022/5/20 12:54
 * @Author: BarryAllen
 * @Description: ViewModelModule
 **************************/

val viewModelModule = module {
    viewModel { KoinViewModel(get()) }
    viewModel { MinebbsViewModel(get()) }
    viewModel { PixabayViewModel(get()) }
    viewModel { CustomViewViewModel() }
    viewModel { BaiduImageNavigationViewModel(get()) }
}