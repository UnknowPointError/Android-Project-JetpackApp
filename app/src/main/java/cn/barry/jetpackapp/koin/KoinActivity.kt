package cn.barry.jetpackapp.koin

import android.os.Bundle
import cn.barry.base.activity.BaseVBActivity
import cn.barry.jetpackapp.databinding.ActivityKoinBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

/*
@Machine: RedmiBook Pro 15
@RelativePath: cn\barry\jetpackapp\koin\KoinActivity.kt
@Path: D:\Barry\B_study\Android\Android_Project\JetpackApp\app\src\main\java\cn\barry\jetpackapp\koin\KoinActivity.kt
@Author: Barry
@Time: 2022/4/28 2:39 周四 上午
@Description: KoinActivity
*/

class KoinActivity : BaseVBActivity<ActivityKoinBinding,KoinViewModel>() {

    override fun getViewBinding(): ActivityKoinBinding = ActivityKoinBinding.inflate(layoutInflater)
    override fun getViewModel(): Lazy<KoinViewModel> = viewModel()
    override fun init(savedInstanceState: Bundle?) {
        with(mBinding) {
            mViewModel.count++
            koinCountText.text = mViewModel.count.toString()
            koinCenterText.text = mViewModel.sayHello()
        }
    }


}