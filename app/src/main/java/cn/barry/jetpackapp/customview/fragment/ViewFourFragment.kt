package cn.barry.jetpackapp.customview.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import cn.barry.base.fragment.BaseVBFragment
import cn.barry.jetpackapp.customview.CustomViewViewModel
import cn.barry.jetpackapp.databinding.FragmentViewFourBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ViewFourFragment : BaseVBFragment<FragmentViewFourBinding,CustomViewViewModel>() {
    override fun getViewBinding(inflater: LayoutInflater) = FragmentViewFourBinding.inflate(inflater)

    override fun getViewModel(): Lazy<CustomViewViewModel> = viewModel()

    override fun init(view: View, savedInstanceState: Bundle?) {

    }
}