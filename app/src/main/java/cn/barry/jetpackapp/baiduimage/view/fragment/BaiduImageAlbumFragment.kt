package cn.barry.jetpackapp.baiduimage.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.barry.base.app.appContext
import com.barry.base.extensions.log
import com.barry.base.fragment.BaseVBFragment
import cn.barry.jetpackapp.R
import cn.barry.jetpackapp.baiduimage.view.activity.BaiduImageNavigationViewModel
import cn.barry.jetpackapp.baiduimage.view.adapter.BaiduImageAlbumAdapter
import cn.barry.jetpackapp.baiduimage.view.adapter.BaiduSelectAlbumAdapter
import cn.barry.jetpackapp.databinding.BaiduAlbumBottomsheetdialogBinding
import cn.barry.jetpackapp.databinding.FragmentAlbumLayoutBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

/*************************
 * @Machine: RedmiBook Pro 15
 * @RelativePath: cn\barry\jetpackapp\baiduimage\view\fragment\BaiduImageAlbumFragment.kt
 * @Path: D:\Barry\B_study\Android\Android_Project\JetpackApp\app\src\main\java\cn\barry\jetpackapp\baiduimage\view\fragment\BaiduImageAlbumFragment.kt
 * @Author: Barry
 * @Time: 2022/5/15 19:38 周日 下午
 * @Description: BaiduImageAlbumFragment
 * @formatter:off
 *************************/

class BaiduImageAlbumFragment : BaseVBFragment<FragmentAlbumLayoutBinding, BaiduImageNavigationViewModel>() {

    override fun getViewBinding(inflater: LayoutInflater) = FragmentAlbumLayoutBinding.inflate(inflater)
    override fun getViewModel(): Lazy<BaiduImageNavigationViewModel> = requireActivity().viewModel()

    override fun doOnInitViewCreate(view: View, savedInstanceState: Bundle?) {
        val selectImageState = ContextCompat.getDrawable(requireContext(), R.drawable.icon_album_image_selectstate)
        val noSelectImageState = ContextCompat.getDrawable(appContext, R.drawable.icon_album_image_no_selectstate)
        val selectCircleState = ContextCompat.getDrawable(appContext,R.drawable.icon_album_circle_select_blue)
        val noSelectCircleState = ContextCompat.getDrawable(appContext,R.drawable.icon_album_circle_no_select)
        with(mViewModel) {
            with(mBinding.baiduImageAlbumRv) {
                layoutManager = GridLayoutManager(requireContext(),4)
                adapter = BaiduImageAlbumAdapter(imagePath,adapterPositionFilterColor).also { albumAdapter ->
                    albumAdapter.mSelectImageClickCallback = { rvBinding,position ->

                        if (adapterPositionFilterColor.contains(position)) {

                            rvBinding.baiduAlbumRvItemImageView.foreground = noSelectImageState
                            rvBinding.baiduAlbumRvItemSelectCircleImage.background = noSelectCircleState
                            adapterPositionFilterColor.remove(position)

                        } else {

                            rvBinding.baiduAlbumRvItemImageView.foreground = selectImageState
                            rvBinding.baiduAlbumRvItemSelectCircleImage.background = selectCircleState
                            adapterPositionFilterColor.add(position)

                        }

                    }
                }
            }
        }
    }
}