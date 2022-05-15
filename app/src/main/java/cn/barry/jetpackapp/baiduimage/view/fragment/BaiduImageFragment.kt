package cn.barry.jetpackapp.baiduimage.view.fragment

import android.content.ContentUris
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import cn.barry.base.extensions.log
import cn.barry.base.extensions.logger
import cn.barry.base.fragment.BaseVBFragment
import cn.barry.jetpackapp.R
import cn.barry.jetpackapp.baiduimage.view.activity.BaiduImageNavigationViewModel
import cn.barry.jetpackapp.databinding.FragmentBaiduImageBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class BaiduImageFragment : BaseVBFragment<FragmentBaiduImageBinding, BaiduImageNavigationViewModel>() {

    init { mIsNeedNetworkLoading = true }

    val openAlbums = registerForActivityResult(ActivityResultContracts.OpenDocument()) {
        it.logger()
    }

    override fun getViewBinding(inflater: LayoutInflater) = FragmentBaiduImageBinding.inflate(inflater)
    override fun getViewModel(): Lazy<BaiduImageNavigationViewModel> = requireActivity().viewModel()
    override fun doOnInitViewCreate(view: View, savedInstanceState: Bundle?) {
        mViewModel.tokenEntity.observe(this) { tokenEntity ->
            mViewModel.token = tokenEntity.token
        }
        mViewModel.tokenEntity.value ?: mViewModel.getAccessToken()


        mBinding.baiduImageAddImage.setOnClickListener {
            findNavController().navigate(R.id.action_baiduImageFragment_to_baiduImageAlbumFragment)
        }

        searchImage()

    }
//    openAlbums.launch(arrayOf("image/*"))
//    mBinding.imageView.setImageURI(imagePath[0])
    private fun searchImage() {
        val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val selection = MediaStore.Images.Media.MIME_TYPE + "=\"image/jpeg\" or " + MediaStore.Images.Media.MIME_TYPE + "=\"image/png\""
        requireContext().contentResolver.query(uri, null, selection, null, MediaStore.Images.Media.DATE_MODIFIED+" desc")?.use { cursor ->
            cursor.apply {
                while (moveToNext()) {
                    val imageUri = ContentUris.withAppendedId(uri, getLong(getColumnIndexOrThrow(
                        MediaStore.Images.ImageColumns._ID)))
                    mViewModel.imagePath.add(imageUri)
                }
            }
        }
        "--------------------".log()
        requireContext().contentResolver.query(uri, null, null, null, MediaStore.Images.Media.DATE_MODIFIED+" desc")?.use { cursor ->
            cursor.apply {
                while (moveToNext()) {
                    val imageUri = ContentUris.withAppendedId(uri, getLong(getColumnIndexOrThrow(
                        MediaStore.Images.Media.DISPLAY_NAME)))
                }
            }
        }
    }

}
