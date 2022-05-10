package cn.barry.jetpackapp.customview

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import cn.barry.base.activity.BaseVBActivity
import cn.barry.jetpackapp.R
import cn.barry.jetpackapp.customview.fragment.ViewFourFragment
import cn.barry.jetpackapp.customview.fragment.ViewOneFragment
import cn.barry.jetpackapp.customview.fragment.ViewThreeFragment
import cn.barry.jetpackapp.customview.fragment.ViewTwoFragment
import cn.barry.jetpackapp.databinding.ActivityCustomViewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


/*************************
 * @Machine: RedmiBook Pro 15
 * @RelativePath: cn\barry\jetpackapp\customview\CustomViewActivity.kt
 * @Path: D:\Barry\B_study\Android\Android_Project\JetpackApp\app\src\main\java\cn\barry\jetpackapp\customview\CustomViewActivity.kt
 * @Author: Barry
 * @Time: 2022/5/8 12:16 周日 下午
 * @Description: CustomViewActivity
 * @formatter:off
 *************************/

class CustomViewActivity : BaseVBActivity<ActivityCustomViewBinding, CustomViewViewModel>() {

    private var mContainerAdapter: ContainerAdapter? = null
    private val fragmentArray: Array<Fragment> = arrayOf(ViewOneFragment(),ViewTwoFragment(),ViewThreeFragment(),ViewFourFragment())
    override fun getViewBinding() = ActivityCustomViewBinding.inflate(layoutInflater)

    override fun getViewModel(): Lazy<CustomViewViewModel> = viewModel()

    override fun init(savedInstanceState: Bundle?) {
        mBinding.customViewViewPager.apply {
            isUserInputEnabled = false
            mContainerAdapter = ContainerAdapter(fragmentArray,supportFragmentManager,lifecycle)
            adapter = mContainerAdapter
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    mBinding.bnvContainer.menu.getItem(position).isChecked = true
                }
            })
        }
        mBinding.bnvContainer.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_bottom_home -> switchFragment(0)
                R.id.menu_bottom_square -> switchFragment(1)
                R.id.menu_bottom_qa -> switchFragment(2)
                R.id.menu_bottom_system -> switchFragment(3)
                else -> switchFragment(0)
            }
            true
        }
    }

    private fun switchFragment(position: Int) {
        if (mBinding.customViewViewPager.currentItem != position) {
            mBinding.customViewViewPager.setCurrentItem(position, false)
        }
    }

    override fun onDestroy(){
        super.onDestroy()
        mContainerAdapter = null
    }
}