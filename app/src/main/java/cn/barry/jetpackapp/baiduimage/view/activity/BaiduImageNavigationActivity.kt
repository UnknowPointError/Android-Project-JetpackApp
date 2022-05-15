package cn.barry.jetpackapp.baiduimage.view.activity

import android.os.Bundle
import cn.barry.base.activity.BaseVBActivity
import cn.barry.jetpackapp.databinding.ActivityBaiduImageNavigationBinding
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

    }
}

