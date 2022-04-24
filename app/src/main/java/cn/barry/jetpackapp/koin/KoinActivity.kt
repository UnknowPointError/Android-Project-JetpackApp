package cn.barry.jetpackapp.koin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cn.barry.base.toast
import cn.barry.jetpackapp.R
import cn.barry.jetpackapp.databinding.ActivityKoinBinding
import org.koin.android.ext.android.inject

class KoinActivity : AppCompatActivity() {

    private val app: SingleClass by inject()
    private val firstPresenter: MySimplePresenter by inject()
    private val mBinding by lazy { ActivityKoinBinding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        with(mBinding) {
            app.count++
            koinCountText.text = app.count.toString()
            koinCenterText.text = firstPresenter.sayHello()
        }
    }
}