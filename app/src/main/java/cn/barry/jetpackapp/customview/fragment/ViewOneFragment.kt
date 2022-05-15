package cn.barry.jetpackapp.customview.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import cn.barry.base.coroutine.defaultCoroutine
import cn.barry.base.fragment.BaseVBFragment
import cn.barry.jetpackapp.customview.CustomViewViewModel
import cn.barry.jetpackapp.databinding.FragmentViewOneBinding
import kotlinx.coroutines.cancel
import org.koin.androidx.viewmodel.ext.android.viewModel


class ViewOneFragment: BaseVBFragment<FragmentViewOneBinding, CustomViewViewModel>() {


    override fun getViewBinding(inflater: LayoutInflater) = FragmentViewOneBinding.inflate(inflater)

    override fun getViewModel(): Lazy<CustomViewViewModel> = viewModel()

    override fun doOnInitViewCreate(view: View, savedInstanceState: Bundle?) {
    }

    override fun onDestroy() {
        super.onDestroy()
        defaultCoroutine.cancel()
    }
}