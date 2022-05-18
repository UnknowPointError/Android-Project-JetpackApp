package cn.barry.jetpackapp

import android.R
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.barry.base.activity.BaseVBActivity
import cn.barry.base.app.appContext
import cn.barry.base.extensions.log
import cn.barry.base.extensions.logger
import cn.barry.base.extensions.toast
import cn.barry.base.startActivity
import cn.barry.jetpackapp.baiduimage.view.activity.BaiduImageNavigationActivity
import cn.barry.jetpackapp.baiduimage.view.adapter.BaiduSelectAlbumAdapter
import cn.barry.jetpackapp.customview.CustomViewActivity
import cn.barry.jetpackapp.databinding.ActivityMainBinding
import cn.barry.jetpackapp.koin.KoinActivity
import cn.barry.jetpackapp.koin.KoinViewModel
import cn.barry.jetpackapp.lifecycle.LifeCycleActivity
import cn.barry.jetpackapp.livedata.LiveDataActivity
import cn.barry.jetpackapp.material.MaterialActivity
import cn.barry.jetpackapp.R.*
import cn.barry.jetpackapp.pixabay.view.PixabayActivity
import com.barry.minebbs.view.activity.MinebbsActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import org.koin.androidx.viewmodel.ext.android.viewModel


/*
@Machine: RedmiBook Pro 15
@RelativePath: cn\barry\jetpackapp\MainActivity.kt
@Path: D:\Barry\B_study\Android\Android_Project\JetpackApp\app\src\main\java\cn\barry\jetpackapp\MainActivity.kt
@Author: Barry
@Time: 2022/4/28 2:56 周四 上午
@Description: MainActivity
*/

class MainActivity : BaseVBActivity<ActivityMainBinding, KoinViewModel>() {

    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
    override fun getViewModel(): Lazy<KoinViewModel> = viewModel()

    override fun doInitOnCreate(savedInstanceState: Bundle?) {


        val array = mutableMapOf("asd" to listOf(Uri.parse("123123")))
        val dialog = BottomSheetDialog(this@MainActivity)
        dialog.setContentView(layout.baidu_album_bottomsheetdialog)
        dialog.also {
            val recyclerView = dialog.findViewById<RecyclerView>(id.album_selectmore_recyclerView)
            recyclerView?.layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)
            recyclerView?.adapter = BaiduSelectAlbumAdapter(array)
            recyclerView?.logger()
            dialog.show()
        }



        title = "MainActivity"
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { request ->
            if (request[android.Manifest.permission.SYSTEM_ALERT_WINDOW] == true) "同意了权限".toast()
            else "拒绝了权限".toast()

            if (request[android.Manifest.permission.READ_EXTERNAL_STORAGE] == true) "同意了权限".toast()
            else "拒绝了权限".toast()
        }.launch(
            arrayOf(
                android.Manifest.permission.SYSTEM_ALERT_WINDOW,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            )
        )

        mBinding.buttonLayout.apply {
            buttonKoinActivity.setOnClickListener {
                /* app属性使用了by inject()是什么意思？
                 by inject()是Koin的一个函数，它的作用是将某个类的实例注入到Koin的容器中，
                 并且返回该实例，这样就可以在Koin的容器中获取该类的实例了。*/
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
            buttonNavigation.setOnClickListener {
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
        }
    }
}