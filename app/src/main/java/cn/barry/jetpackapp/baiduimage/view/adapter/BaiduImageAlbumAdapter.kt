package cn.barry.jetpackapp.baiduimage.view.adapter

import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.core.view.setMargins
import androidx.navigation.findNavController
import com.barry.base.adapter.BaseRvVBAdapter
import com.barry.base.app.appContext
import cn.barry.jetpackapp.R
import cn.barry.jetpackapp.databinding.BaiduAlbumRvItemBinding
import com.bumptech.glide.Glide


/*************************
 * @Machine: RedmiBook Pro 15 Win11
 * @Path: app/src/main/java/cn/barry/jetpackapp/baiduimage/view
 * @Time: 2022/5/13 18:46
 * @Author: BarryAllen
 * @Description: BaiduImageAlbumAdapter
 * @formatter:off
 **************************/

class BaiduImageAlbumAdapter(val imageList: List<Uri>, val adapterPositionFilterColor: MutableList<Int>): BaseRvVBAdapter<BaiduAlbumRvItemBinding>() {

    internal var mSelectImageClickCallback: ((mBinding: BaiduAlbumRvItemBinding,position: Int) -> Unit)? = null
    private val mNoSelectImageState = ContextCompat.getDrawable(appContext,R.drawable.icon_album_image_no_selectstate)
    private val mSelectImageState = ContextCompat.getDrawable(appContext,R.drawable.icon_album_image_selectstate)
    private val mNoSelectCircleState = ContextCompat.getDrawable(appContext, R.drawable.icon_album_circle_no_select)
    private val mSelectCircleState = ContextCompat.getDrawable(appContext, R.drawable.icon_album_circle_select_blue)

    private val mImageLayoutParams = FrameLayout.LayoutParams(appContext.resources.displayMetrics.widthPixels / 4,appContext.resources.displayMetrics.widthPixels / 4)
    private val mCircleLayoutParams = FrameLayout.LayoutParams(mImageLayoutParams.width / 4, mImageLayoutParams.height / 4).apply {
        gravity = Gravity.END
        setMargins(5)
    }

    override fun getViewBinding(parent: ViewGroup) = BaiduAlbumRvItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    override fun getItemCount(): Int = imageList.size

    override fun onBindViewHolder(holder: BaseRvVBHolder, position: Int) {
        holder.mBinding.apply {
            if (adapterPositionFilterColor.contains(position)) {
                baiduAlbumRvItemSelectCircleImage.background = mSelectCircleState
                baiduAlbumRvItemImageView.foreground = mSelectImageState
            } else {
                baiduAlbumRvItemSelectCircleImage.background = mNoSelectCircleState
                baiduAlbumRvItemImageView.foreground = mNoSelectImageState
            }
            baiduAlbumRvItemImageView.layoutParams = mImageLayoutParams
            baiduAlbumRvItemSelectCircleImage.layoutParams = mCircleLayoutParams
            Glide.with(appContext)
                .load(imageList[position])
                .placeholder(R.drawable.ic_baseline_looks_one_24)
                .into(baiduAlbumRvItemImageView)
        }
    }

    context (BaseRvVBHolder) override fun initCreateViewHolder(){
        mBinding.baiduAlbumRvItemImageView.setOnClickListener { view ->
            Bundle().apply {
                putParcelable("ImagePosition",imageList[adapterPosition])
                view.findNavController().navigate(R.id.action_baiduImageAlbumFragment_to_baiduImageAlbumPhotoFragment, this)
            }
        }
        mBinding.baiduAlbumRvItemSelectCircleImage.setOnClickListener { mSelectImageClickCallback?.invoke(mBinding, adapterPosition) }
    }
}