package cn.barry.jetpackapp.baiduimage.view.adapter

import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.view.setMargins
import androidx.navigation.findNavController
import cn.barry.base.adapter.BaseRvVBAdapter
import cn.barry.base.app.appContext
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

class BaiduImageAlbumAdapter(val imageList: List<Uri>): BaseRvVBAdapter<BaiduAlbumRvItemBinding>() {

    internal var mSelectImageClickCallback: ((mBinding: BaiduAlbumRvItemBinding,position: Int) -> Unit)? = null
    private val layoutParams = FrameLayout.LayoutParams(appContext.resources.displayMetrics.widthPixels / 4,appContext.resources.displayMetrics.widthPixels / 4)
    private val selectLayoutParams = FrameLayout.LayoutParams(layoutParams.width / 5,layoutParams.height / 5).apply {
        gravity = Gravity.END
        setMargins(5)
    }

    override fun getViewBinding(parent: ViewGroup) = BaiduAlbumRvItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    override fun getItemCount(): Int = imageList.size
    override fun BaseRvVBHolder.initCreateViewHolder(){
        mBinding.baiduAlbumRvItemImageView.setOnClickListener { view ->
            Bundle().apply {
                putParcelable("ImagePosition",imageList[adapterPosition])
                view.findNavController().navigate(R.id.action_baiduImageAlbumFragment_to_baiduImageAlbumPhotoFragment, this)
            }
        }
        mBinding.baiduAlbumRvItemSelectCircleImage.setOnClickListener { mSelectImageClickCallback?.invoke(mBinding, adapterPosition) }
    }
    override fun onBindViewHolder(holder: BaseRvVBHolder, position: Int) {
        holder.mBinding.apply {
            baiduAlbumRvItemImageView.layoutParams = this@BaiduImageAlbumAdapter.layoutParams
            baiduAlbumRvItemSelectCircleImage.layoutParams = this@BaiduImageAlbumAdapter.selectLayoutParams
            Glide.with(appContext)
                .load(imageList[position])
                .placeholder(R.drawable.ic_baseline_looks_one_24)
                .into(baiduAlbumRvItemImageView)
        }
    }
}