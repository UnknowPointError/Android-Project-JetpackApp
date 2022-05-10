package com.barry.minebbs.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import cn.barry.base.fragment.BaseVBFragment
import com.barry.minebbs.R
import com.barry.minebbs.databinding.FragmentUserIconBinding
import com.barry.minebbs.view.activity.MinebbsViewModel
import com.barry.minebbs.view.adapter.UserIconRvAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


/*************************
 * @Machine: RedmiBook Pro 15
 * @RelativePath: com\barry\minebbs\view\fragment\UserIconFragment.kt
 * @Path: D:\Barry\B_study\Android\Android_Project\JetpackApp\minebbs\src\main\java\com\barry\minebbs\view\fragment\UserIconFragment.kt
 * @Author: Barry
 * @Time: 2022/5/4 20:22 周三 下午
 * @Time: 2022/5/4 20:22 周三 下午
 * @Description: UserIconFragment
 * @formatter:off
 *************************/

class UserIconFragment : BaseVBFragment<FragmentUserIconBinding, MinebbsViewModel>() {

    init { isNeedLazy = true }

    val adapter = UserIconRvAdapter(mutableListOf(1))

    override fun getViewModel(): Lazy<MinebbsViewModel> = requireActivity().viewModel()
    override fun getViewBinding(inflater: LayoutInflater) = FragmentUserIconBinding.inflate(inflater)

    override fun lazyData() {
        mBinding.userIconRecyclerView.layoutManager = GridLayoutManager(context, 2)
        mBinding.userIconRecyclerView.adapter = adapter
    }

    override fun init(view: View, savedInstanceState: Bundle?) {
        mViewModel.userIconEntityInfo.observe(viewLifecycleOwner) {

        }
        adapter.itemView = { mBinding ->
            mViewModel.drawable = adapter.getDrawables()
            Navigation.findNavController(mBinding.root).navigate(R.id.action_userIcon_to_fullScreen)
        }
    }
}