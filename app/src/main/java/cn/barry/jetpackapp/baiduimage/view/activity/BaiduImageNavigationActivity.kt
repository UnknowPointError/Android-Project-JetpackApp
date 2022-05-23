package cn.barry.jetpackapp.baiduimage.view.activity

import android.graphics.Color
import android.os.Bundle
import android.view.WindowManager
import cn.barry.jetpackapp.databinding.ActivityBaiduImageNavigationBinding
import com.barry.base.activity.BaseVBActivity
import com.barry.base.view.setStatusBarIsDark
import org.koin.androidx.viewmodel.ext.android.viewModel

/*************************
 * @Machine: RedmiBook Pro 15
 * @RelativePath: cn\barry\jetpackapp\baiduimage\view\BaiduImageActivity.kt
 * @Path: D:\Barry\B_study\Android\Android_Project\JetpackApp\app\src\main\java\cn\barry\jetpackapp\baiduimage\view\BaiduImageActivity.kt
 * @Author: Barry
 * @Time: 2022/5/13 15:21 周五 下午
 * @Description: BaiduImageActivity
 * @formatter:off
 *************************/

class BaiduImageNavigationActivity : BaseVBActivity<ActivityBaiduImageNavigationBinding, BaiduImageNavigationViewModel>() {

    override fun getViewBinding() = ActivityBaiduImageNavigationBinding.inflate(layoutInflater)

    override fun getViewModel(): Lazy<BaiduImageNavigationViewModel> = viewModel()

    override fun doInitOnCreate(savedInstanceState: Bundle?) {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.TRANSPARENT
        setStatusBarIsDark(true)
    }
}

