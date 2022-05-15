package cn.barry.jetpackapp.baiduimage.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import cn.barry.base.app.appContext
import cn.barry.base.fragment.BaseVBFragment
import cn.barry.jetpackapp.R
import cn.barry.jetpackapp.baiduimage.view.activity.BaiduImageNavigationViewModel
import cn.barry.jetpackapp.baiduimage.view.adapter.BaiduImageAlbumAdapter
import cn.barry.jetpackapp.databinding.FragmentAlbumLayoutBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class BaiduImageAlbumFragment : BaseVBFragment<FragmentAlbumLayoutBinding, BaiduImageNavigationViewModel>() {

    override fun getViewBinding(inflater: LayoutInflater) = FragmentAlbumLayoutBinding.inflate(inflater)
    override fun getViewModel(): Lazy<BaiduImageNavigationViewModel> = requireActivity().viewModel()

    override fun doOnInitViewCreate(view: View, savedInstanceState: Bundle?) {
        mBinding.baiduImageAlbumRv.apply {
            layoutManager = GridLayoutManager(requireContext(),4)
            adapter = BaiduImageAlbumAdapter(mViewModel.imagePath).also { albumAdapter ->
                albumAdapter.mSelectImageClickCallback = { mBinding,position ->
                    if (mViewModel.adapterPositionFilterColor.contains(position)) {
                        mBinding.baiduAlbumRvItemImageView.setColorFilter(android.R.color.transparent)
                        mBinding.baiduAlbumRvItemSelectCircleImage.background = ContextCompat.getDrawable(appContext,R.drawable.icon_album_circle)
                        mViewModel.adapterPositionFilterColor.remove(position)
                    } else {
                        mBinding.baiduAlbumRvItemSelectCircleImage.background = ContextCompat.getDrawable(appContext,R.drawable.icon_album_circle_blue)
                        mBinding.baiduAlbumRvItemSelectCircleImage.setColorFilter(R.color.album_image_translate)
                        mViewModel.adapterPositionFilterColor.add(position)
                    }
                }
            }
        }
    }
}