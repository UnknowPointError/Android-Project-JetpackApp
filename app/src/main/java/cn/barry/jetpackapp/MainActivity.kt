package cn.barry.jetpackapp

import android.app.DownloadManager
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.barry.base.activity.BaseVBActivity
import com.barry.base.extensions.toast
import com.barry.base.extensions.startActivity
import cn.barry.jetpackapp.R.*
import cn.barry.jetpackapp.baiduimage.view.activity.BaiduImageNavigationActivity
import cn.barry.jetpackapp.customview.CustomViewActivity
import cn.barry.jetpackapp.databinding.ActivityMainBinding
import cn.barry.jetpackapp.downloads.DownloadActivity
import cn.barry.jetpackapp.koin.KoinActivity
import cn.barry.jetpackapp.koin.KoinViewModel
import cn.barry.jetpackapp.lifecycle.LifeCycleActivity
import cn.barry.jetpackapp.livedata.LiveDataActivity
import cn.barry.jetpackapp.material.MaterialActivity
import cn.barry.jetpackapp.minebbs.view.activity.MinebbsActivity
import cn.barry.jetpackapp.pixabay.view.PixabayActivity
import org.koin.androidx.viewmodel.ext.android.viewModel


/*************************
 * @Machine: RedmiBook Pro 15
 * @RelativePath: cn\barry\jetpackapp\MainActivity.kt
 * @Path: D:\Barry\B_study\Android\Android_Project\JetpackApp\app\src\main\java\cn\barry\jetpackapp\MainActivity.kt
 * @Author: Barry
 * @Time: 2022/4/28 2:56 ε¨ε δΈε
 * @Description: MainActivity
 * @formatter:off
 *************************/

class MainActivity : BaseVBActivity<ActivityMainBinding, KoinViewModel>() {

    companion object {
        const val SYSTEM_ALERT_WINDOW = android.Manifest.permission.SYSTEM_ALERT_WINDOW
        const val READ_EXTERNAL_STORAGE = android.Manifest.permission.READ_EXTERNAL_STORAGE
    }

    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
    override fun getViewModel(): Lazy<KoinViewModel> = viewModel()
    override fun doInitOnCreate(savedInstanceState: Bundle?) {

        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { request ->
            if (request[SYSTEM_ALERT_WINDOW] == true) grantPermission()
            else denyPermission()

            if (request[READ_EXTERNAL_STORAGE] == true) grantPermission()
            else denyPermission()
        }.launch(arrayOf(SYSTEM_ALERT_WINDOW, READ_EXTERNAL_STORAGE))

        mBinding.buttonLayout.apply {
            buttonKoinActivity.setOnClickListener {
                /* appε±ζ§δ½Ώη¨δΊby inject()ζ―δ»δΉζζοΌ
                 by inject()ζ―KoinηδΈδΈͺε½ζ°οΌε?ηδ½η¨ζ―ε°ζδΈͺη±»ηε?δΎζ³¨ε₯ε°Koinηε?Ήε¨δΈ­οΌ
                 εΉΆδΈθΏεθ―₯ε?δΎοΌθΏζ ·ε°±ε―δ»₯ε¨Koinηε?Ήε¨δΈ­θ·εθ―₯η±»ηε?δΎδΊγ*/
                startActivity<KoinActivity> { }
                overridePendingTransition(anim.anim_in, anim.anim_out)
                mViewModel.addCount()
                mViewModel.sayHello()
            }
            buttonLifecycle.setOnClickListener {
                startActivity<LifeCycleActivity> { }
            }
            buttonLivedata.setOnClickListener {
                startActivity<LiveDataActivity> { }
            }
            buttonMaterial.setOnClickListener {
                startActivity<MaterialActivity> { }
            }
            buttonMinebbs.setOnClickListener {
                startActivity<MinebbsActivity> { }
            }
            buttonPixabay.setOnClickListener {
                startActivity<PixabayActivity> { }
            }
            buttonCustomView.setOnClickListener {
                startActivity<CustomViewActivity>()
            }
            buttonBaiduImage.setOnClickListener {
                startActivity<BaiduImageNavigationActivity> { }
            }
            buttonDownload.setOnClickListener {
                startActivity<DownloadActivity> {  }
            }
        }
    }

    private fun denyPermission() = "ζη»δΊζι".toast()
    private fun grantPermission() = "εζδΊζι".toast()
}

