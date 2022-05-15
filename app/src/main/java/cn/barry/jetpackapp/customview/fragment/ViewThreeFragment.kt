package cn.barry.jetpackapp.customview.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import cn.barry.base.fragment.BaseVBFragment
import cn.barry.jetpackapp.customview.CustomViewViewModel
import cn.barry.jetpackapp.databinding.FragmentViewThreeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ViewThreeFragment : BaseVBFragment<FragmentViewThreeBinding,CustomViewViewModel>() {

    override fun getViewBinding(inflater: LayoutInflater) = FragmentViewThreeBinding.inflate(inflater)

    override fun getViewModel(): Lazy<CustomViewViewModel> = viewModel()

    override fun doOnInitViewCreate(view: View, savedInstanceState: Bundle?) {

    }

}
