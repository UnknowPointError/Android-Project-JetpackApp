package cn.barry.jetpackapp.koin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cn.barry.base.toast
import cn.barry.jetpackapp.databinding.ActivityKoinBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

/*
@Machine: RedmiBook Pro 15
@RelativePath: cn\barry\jetpackapp\koin\KoinActivity.kt
@Path: D:\Barry\B_study\Android\Android_Project\JetpackApp\app\src\main\java\cn\barry\jetpackapp\koin\KoinActivity.kt
@Author: Barry
@Time: 2022/4/28 2:39 周四 上午
@Description: KoinActivity
*/

class KoinActivity : AppCompatActivity() {

    private val firstPresenter: KoinViewModel by inject()
    private val mBinding by lazy { ActivityKoinBinding.inflate(layoutInflater) }
    private val _viewModel: Lazy<KoinViewModel> = viewModel()
    private val viewmodel by lazy { _viewModel.value }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        with(mBinding) {
            viewmodel.count++
            koinCountText.text = viewmodel.count.toString()
            koinCenterText.text = firstPresenter.sayHello()
            viewmodel.sayHello().toast()
        }
    }
}