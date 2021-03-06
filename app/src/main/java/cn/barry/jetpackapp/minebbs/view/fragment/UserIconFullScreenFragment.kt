package cn.barry.jetpackapp.minebbs.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.barry.base.fragment.BaseVBFragment
import cn.barry.jetpackapp.databinding.FragmentMinebbsUserIconFullScreenBinding
import cn.barry.jetpackapp.minebbs.view.activity.MinebbsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/*************************
 * @Machine: RedmiBook Pro 15
 * @RelativePath: com\barry\minebbs\view\fragment\UserIconFullScreenFragment.kt
 * @Path: D:\Barry\B_study\Android\Android_Project\JetpackApp\minebbs\src\main\java\com\barry\minebbs\view\fragment\UserIconFullScreenFragment.kt
 * @Author: Barry
 * @Time: 2022/5/5 12:21 ε¨ε δΈε
 * @Description: UserIcon_FullScreen
 * @formatter:off
 *************************/

class UserIconFullScreenFragment : BaseVBFragment<FragmentMinebbsUserIconFullScreenBinding,MinebbsViewModel>() {

    override fun getViewModel(): Lazy<MinebbsViewModel> = requireActivity().viewModel()
    override fun getViewBinding(inflater: LayoutInflater): FragmentMinebbsUserIconFullScreenBinding = FragmentMinebbsUserIconFullScreenBinding.inflate(inflater)

    override fun doOnInitViewCreate(view: View, savedInstanceState: Bundle?){
        mBinding.userIconFullScreenImageView.setImageDrawable(mViewModel.drawable)
    }
}