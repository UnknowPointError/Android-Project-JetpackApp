package cn.barry.jetpackapp.pixabay.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.barry.base.extensions.logger
import com.barry.base.fragment.BaseVBFragment
import cn.barry.jetpackapp.databinding.FragmentPixabayBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class PixabayFragment : BaseVBFragment<FragmentPixabayBinding, PixabayViewModel>() {

    init {
        mIsNeedNetworkLoading = true
    }

    override fun getViewBinding(inflater: LayoutInflater) = FragmentPixabayBinding.inflate(inflater)
    override fun getViewModel(): Lazy<PixabayViewModel> = requireActivity().viewModel()

    override fun doOnInitViewCreate(view: View, savedInstanceState: Bundle?) {
        val pixabayAdapter = PixabayAdapter()
        mBinding.pixabayImageRecyclerView.apply {
            adapter = pixabayAdapter
            layoutManager = GridLayoutManager(requireContext(),2)
        }

        mViewModel.pixabayImageInfo.observe(this) { pixabayChildImageData ->
            pixabayAdapter.submitList(pixabayChildImageData)
            "sub".logger()
        }


        mBinding.pixabaySwipeRefreshLayout.setOnRefreshListener {
            mViewModel.fetchImage()
            mBinding.pixabaySwipeRefreshLayout.isRefreshing = false
        }

        mViewModel.pixabayImageInfo.value ?: mViewModel.fetchImage()
    }
}