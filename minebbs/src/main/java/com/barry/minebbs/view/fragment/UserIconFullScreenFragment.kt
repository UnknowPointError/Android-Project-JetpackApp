package com.barry.minebbs.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import cn.barry.base.fragment.BaseVBFragment
import com.barry.minebbs.databinding.FragmentUserIconFullScreenBinding
import com.barry.minebbs.view.activity.MinebbsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/*************************
 * @Machine: RedmiBook Pro 15
 * @RelativePath: com\barry\minebbs\view\fragment\UserIconFullScreenFragment.kt
 * @Path: D:\Barry\B_study\Android\Android_Project\JetpackApp\minebbs\src\main\java\com\barry\minebbs\view\fragment\UserIconFullScreenFragment.kt
 * @Author: Barry
 * @Time: 2022/5/5 12:21 周四 下午
 * @Description: UserIcon_FullScreen
 * @formatter:off
 *************************/

class UserIconFullScreenFragment : BaseVBFragment<FragmentUserIconFullScreenBinding,MinebbsViewModel>() {

    override fun getViewModel(): Lazy<MinebbsViewModel> = requireActivity().viewModel()
    override fun getViewBinding(inflater: LayoutInflater): FragmentUserIconFullScreenBinding = FragmentUserIconFullScreenBinding.inflate(inflater)

    override fun init(view: View, savedInstanceState: Bundle?) {
        mBinding.userIconFullScreenImageView.setImageDrawable(mViewModel.drawable)
    }
}