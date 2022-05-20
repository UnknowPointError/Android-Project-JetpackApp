package cn.barry.jetpackapp.baiduimage.view.fragment

import android.content.ContentUris
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.barry.base.extensions.log
import com.barry.base.extensions.logger
import com.barry.base.fragment.BaseVBFragment
import cn.barry.jetpackapp.R
import cn.barry.jetpackapp.baiduimage.view.activity.BaiduImageNavigationViewModel
import cn.barry.jetpackapp.databinding.FragmentBaiduImageBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.File
import kotlin.io.path.name

/*************************
 * @Machine: RedmiBook Pro 15
 * @RelativePath: cn\barry\jetpackapp\baiduimage\view\fragment\BaiduImageFragment.kt
 * @Path: D:\Barry\B_study\Android\Android_Project\JetpackApp\app\src\main\java\cn\barry\jetpackapp\baiduimage\view\fragment\BaiduImageFragment.kt
 * @Author: Barry
 * @Time: 2022/5/15 19:48 周日 下午
 * @Description: BaiduImageFragment
 * @formatter:off
 *************************/

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
            if (mViewModel.adapterPositionFilterColor.size > 0) mViewModel.adapterPositionFilterColor.removeAll(mViewModel.adapterPositionFilterColor)
            findNavController().navigate(R.id.action_baiduImageFragment_to_baiduImageAlbumFragment)
        }

        lifecycleScope.launch(Dispatchers.Default) {
            searchImage()
        }
    }

    private fun searchImage() {
        /*val selection = MediaStore.Images.Media.MIME_TYPE + "=\"image/jpeg\" or " + MediaStore.Images.Media.MIME_TYPE + "=\"image/png\""
        requireContext().contentResolver.query(uri, null, null, null, MediaStore.Images.Media.DATE_MODIFIED+" desc")?.use { cursor ->
            cursor.apply {
                while (moveToNext()) {
                    val imageUri = ContentUris.withAppendedId(uri, getLong(getColumnIndexOrThrow(MediaStore.Images.ImageColumns._ID)))
                    mViewModel.imagePath.add(imageUri)
                }
            }
        }*/
        val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        requireContext().contentResolver.query(uri,null, null , null, MediaStore.Images.Media.DATE_MODIFIED+" desc")?.use { cursor ->
            cursor.apply {
                val uriList = mutableListOf<Uri>()
                while (moveToNext()) {
                    val pathName = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                        val path = getString(getColumnIndexOrThrow(MediaStore.Images.ImageColumns.RELATIVE_PATH))
                        val imageUri = ContentUris.withAppendedId(uri, getLong(getColumnIndexOrThrow(MediaStore.Images.ImageColumns._ID)))
                        mViewModel.imagePath.add(imageUri)
                        uriList.add(imageUri)
                        File(path).name
                    } else {
                        val path = getString(getColumnIndexOrThrow(MediaStore.Images.ImageColumns.DATA))
                        val imageUri = ContentUris.withAppendedId(uri, getLong(getColumnIndexOrThrow(MediaStore.Images.ImageColumns._ID)))
                        uriList.add(imageUri)
                        mViewModel.imagePath.add(imageUri)
                        File(path).parent?: ""
                    }
                    mViewModel.imageMapPath[pathName] = uriList
                }
            }
        }
        mViewModel.imagePath.size.logger() /* 5595 */
        mViewModel.imageMapPath.size.logger() /* 5595 */
    }
}
