package cn.barry.jetpackapp.minebbs.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.barry.base.fragment.BaseVBFragment
import cn.barry.jetpackapp.R
import cn.barry.jetpackapp.databinding.FragmentMinebbsUserIconBinding
import cn.barry.jetpackapp.minebbs.view.activity.MinebbsViewModel
import cn.barry.jetpackapp.minebbs.view.adapter.UserIconRvAdapter
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

class UserIconFragment : BaseVBFragment<FragmentMinebbsUserIconBinding, MinebbsViewModel>() {

    init { mIsNeedLazy = true }

    val adapter = UserIconRvAdapter(mutableListOf(1))

    override fun getViewModel(): Lazy<MinebbsViewModel> = requireActivity().viewModel()
    override fun getViewBinding(inflater: LayoutInflater) = FragmentMinebbsUserIconBinding.inflate(inflater)

    override fun lazyData() {
        mBinding.userIconRecyclerView.layoutManager = GridLayoutManager(context, 2)
        mBinding.userIconRecyclerView.adapter = adapter
    }

    override fun doOnInitViewCreate(view: View, savedInstanceState: Bundle?) {
        mViewModel.userIconEntityInfo.observe(viewLifecycleOwner) {

        }
        adapter.itemViewCallback = { mBinding ->
            mViewModel.drawable = adapter.getDrawables()
            Navigation.findNavController(mBinding.root).navigate(R.id.action_userIcon_to_fullScreen)
        }
    }
}