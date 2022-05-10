package com.barry.minebbs.view.activity

import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import cn.barry.base.activity.BaseVBActivity
import cn.barry.base.extensions.logInfo
import com.barry.minebbs.R
import com.barry.minebbs.databinding.ActivityMinebbsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

/*************************
 * @Machine: RedmiBook Pro 15
 * @RelativePath: cn\barry\jetpackapp\navigation\NavigationActivity.kt
 * @Path: D:\Barry\B_study\Android\Android_Project\JetpackApp\app\src\main\java\cn\barry\jetpackapp\navigation\NavigationActivity.kt
 * @Author: Barry
 * @Time: 2022/5/1 14:50 周日 下午
 * @Description:
 * @formatter:off
 *************************/
class MinebbsActivity : BaseVBActivity<ActivityMinebbsBinding, MinebbsViewModel>() {
    init { isNeedLazy = true }
    override fun getViewBinding() = ActivityMinebbsBinding.inflate(layoutInflater)
    override fun getViewModel(): Lazy<MinebbsViewModel> = viewModel()
    override fun init(savedInstanceState: Bundle?) {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_fragmentContainerView) as NavHostFragment
        val controller = navHostFragment.navController
        NavigationUI.setupActionBarWithNavController(this,controller)
        mViewModel.templateEntityInfo.observe(this) { dataList ->
            dataList.toString().logInfo()
        }
    }

    override fun onSupportNavigateUp(): Boolean{
        return Navigation.findNavController(this,R.id.nav_fragmentContainerView).navigateUp()
    }


    override fun lazyData(){
        mViewModel.getTemplateEntityInfo()
    }
}