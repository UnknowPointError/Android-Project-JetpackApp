package cn.barry.jetpackapp.minebbs.view.activity

import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.barry.base.activity.BaseVBActivity
import com.barry.base.extensions.logInfo
import cn.barry.jetpackapp.R
import cn.barry.jetpackapp.databinding.ActivityMinebbsBinding
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

    init {
        mIsNeedLazy = true
        mIsNeedNetWorkLoading = true
    }

    override fun getViewBinding() = ActivityMinebbsBinding.inflate(layoutInflater)
    override fun getViewModel(): Lazy<MinebbsViewModel> = viewModel()
    override fun doInitOnCreate(savedInstanceState: Bundle?){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_fragmentContainerView) as NavHostFragment
        val controller = navHostFragment.navController
        NavigationUI.setupActionBarWithNavController(this,controller)
        mViewModel.templateEntityInfo.observe(this) { dataList ->
            dataList.toString().logInfo()
        }
    }

    override fun lazyData(){
        mViewModel.getTemplateEntityInfo()
    }

    override fun onSupportNavigateUp(): Boolean{
        return Navigation.findNavController(this,R.id.nav_fragmentContainerView).navigateUp()
    }

}