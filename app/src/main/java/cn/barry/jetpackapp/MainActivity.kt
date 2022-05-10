package cn.barry.jetpackapp

import android.app.AlertDialog
import android.content.ContextWrapper
import android.content.Intent
import android.graphics.PixelFormat
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import cn.barry.base.activity.BaseVBActivity
import cn.barry.base.app.appContext
import cn.barry.base.extensions.log
import cn.barry.base.extensions.logger
import cn.barry.base.extensions.toast
import cn.barry.base.startActivity
import cn.barry.jetpackapp.customview.CustomViewActivity
import cn.barry.jetpackapp.databinding.ActivityMainBinding
import cn.barry.jetpackapp.koin.KoinActivity
import cn.barry.jetpackapp.koin.KoinViewModel
import cn.barry.jetpackapp.lifecycle.LifeCycleActivity
import cn.barry.jetpackapp.livedata.LiveDataActivity
import cn.barry.jetpackapp.material.MaterialActivity
import cn.barry.jetpackapp.pixabay.view.PixabayActivity
import com.barry.minebbs.view.activity.MinebbsActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

/*
@Machine: RedmiBook Pro 15
@RelativePath: cn\barry\jetpackapp\MainActivity.kt
@Path: D:\Barry\B_study\Android\Android_Project\JetpackApp\app\src\main\java\cn\barry\jetpackapp\MainActivity.kt
@Author: Barry
@Time: 2022/4/28 2:56 周四 上午
@Description: MainActivity
*/

class MainActivity : BaseVBActivity<ActivityMainBinding,KoinViewModel>(), View.OnClickListener {

    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
    override fun getViewModel(): Lazy<KoinViewModel> = viewModel()
    override fun init(savedInstanceState: Bundle?) {
        title = "MainActivity"
        with(mBinding.buttonLayout) {
            buttonKoinActivity.setOnClickListener(this@MainActivity)
            buttonLifecycle.setOnClickListener(this@MainActivity)
            buttonLivedata.setOnClickListener(this@MainActivity)
            buttonMaterial.setOnClickListener(this@MainActivity)
            buttonNavigation.setOnClickListener(this@MainActivity)
            buttonPixabay.setOnClickListener(this@MainActivity)
            buttonCustomView.setOnClickListener(this@MainActivity)
        }
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { request ->
            if(request) {
                "同意了权限".toast()
            } else {
                "拒绝了权限".toast()
            }
        }.launch(android.Manifest.permission.SYSTEM_ALERT_WINDOW)
        val metrics = appContext.resources.displayMetrics
        metrics.apply {
            "densityDpi : $densityDpi".log()
            "density : $density".log()
            "widthPixels : $widthPixels".log()
            "heightPixels : $heightPixels".log()
        }
    }
    override fun onClick(v: View?) {
        with(mBinding.buttonLayout) {
            when (v?.id) {
                buttonKoinActivity.id -> {
                    /* app属性使用了by inject()是什么意思？
                     by inject()是Koin的一个函数，它的作用是将某个类的实例注入到Koin的容器中，
                     并且返回该实例，这样就可以在Koin的容器中获取该类的实例了。*/
                    startActivity<KoinActivity> { }
                    overridePendingTransition(R.anim.anim_in, R.anim.anim_out)
                    mViewModel.count++
                    mViewModel.sayHello()
                }
                buttonLifecycle.id -> {
                    startActivity<LifeCycleActivity> { }
                }
                buttonLivedata.id -> {
                    startActivity<LiveDataActivity> { }
                }
                buttonMaterial.id -> {
                    startActivity<MaterialActivity> {  }
                }
                buttonNavigation.id -> {
                    startActivity<MinebbsActivity> {  }
                }
                buttonPixabay.id -> {
                    startActivity<PixabayActivity> { }
                }
                buttonCustomView.id -> {
                    startActivity<CustomViewActivity>()
                }
                else -> {}
            }
        }
    }

}
