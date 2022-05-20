package cn.barry.jetpackapp.baiduimage.view.fragment

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.barry.base.fragment.BaseVBFragment
import cn.barry.jetpackapp.R
import cn.barry.jetpackapp.baiduimage.view.activity.BaiduImageNavigationViewModel
import cn.barry.jetpackapp.databinding.FragmentBaiduImageAlbumPhotoBinding
import com.bumptech.glide.Glide
import org.koin.androidx.viewmodel.ext.android.viewModel

/*************************
 * @Machine: RedmiBook Pro 15
 * @RelativePath: cn\barry\jetpackapp\baiduimage\view\fragment\BaiduImageAlbumPhotoFragment.kt
 * @Path: D:\Barry\B_study\Android\Android_Project\JetpackApp\app\src\main\java\cn\barry\jetpackapp\baiduimage\view\fragment\BaiduImageAlbumPhotoFragment.kt
 * @Author: Barry
 * @Time: 2022/5/13 21:43 周五 下午
 * @Description: BaiduImageAlbumPhotoFragment
 * @formatter:off
 *************************/

class BaiduImageAlbumPhotoFragment : BaseVBFragment<FragmentBaiduImageAlbumPhotoBinding,BaiduImageNavigationViewModel>() {

    override fun getViewBinding(inflater: LayoutInflater) = FragmentBaiduImageAlbumPhotoBinding.inflate(inflater)
    override fun getViewModel(): Lazy<BaiduImageNavigationViewModel> = requireActivity().viewModel()

    override fun doOnInitViewCreate(view: View, savedInstanceState: Bundle?) {
        val imageUri = arguments?.getParcelable<Uri>("ImagePosition") ?: throw NullPointerException("arguments uri is NULL")
        mBinding.apply {
            Glide.with(this@BaiduImageAlbumPhotoFragment)
                .load(imageUri)
                .placeholder(R.drawable.icon_network_default_loading)
                .into(baiduImageAlbumPhotoPhotoView)
        }
    }
}