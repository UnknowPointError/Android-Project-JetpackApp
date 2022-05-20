package cn.barry.jetpackapp.pixabay.view

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import cn.barry.jetpackapp.R
import cn.barry.jetpackapp.databinding.FragmentPixabayPhotoBinding
import cn.barry.jetpackapp.pixabay.PixabayEntity_Child_Image
import com.barry.base.fragment.BaseVBFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import org.koin.androidx.viewmodel.ext.android.viewModel

/*************************
 * @Machine: RedmiBook Pro 15
 * @RelativePath: cn\barry\jetpackapp\pixabay\view\PixabayPhotoFragment.kt
 * @Path: D:\Barry\B_study\Android\Android_Project\JetpackApp\app\src\main\java\cn\barry\jetpackapp\pixabay\view\PixabayPhotoFragment.kt
 * @Author: Barry
 * @Time: 2022/5/11 16:43 周三 下午
 * @Description: PixabayPhotoFragment
 * @formatter:off
 *************************/

class PixabayPhotoFragment : BaseVBFragment<FragmentPixabayPhotoBinding, PixabayViewModel>() {
    override fun getViewBinding(inflater: LayoutInflater) = FragmentPixabayPhotoBinding.inflate(inflater)

    override fun getViewModel(): Lazy<PixabayViewModel> = requireActivity().viewModel()

    override fun doOnInitViewCreate(view: View, savedInstanceState: Bundle?) {
        mBinding.pixabayPhotoShimmerLayout.apply {
            setShimmerColor(0x55FFFFFF)
            setShimmerAngle(0)
            startShimmerAnimation()
        }
        Glide.with(requireContext())
            .load(arguments?.getParcelable<PixabayEntity_Child_Image>("PHOTO")?.largeImageUrl)
            .placeholder(R.drawable.steve)
            .addListener(object : RequestListener<Drawable>{
                override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                    return false
                }

                override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                    return false.also { mBinding.pixabayPhotoShimmerLayout.stopShimmerAnimation() }
                }
            })
            .into(mBinding.pixabayPhotoView)
    }
}