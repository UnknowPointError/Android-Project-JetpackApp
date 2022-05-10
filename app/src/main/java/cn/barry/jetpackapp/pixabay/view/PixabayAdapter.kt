package cn.barry.jetpackapp.pixabay.view

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import cn.barry.base.adapter.BaseRvVBListAdapter
import cn.barry.jetpackapp.R
import cn.barry.jetpackapp.databinding.PixabayRvImageItemBinding
import cn.barry.jetpackapp.pixabay.PixabayEntity_Child_Image
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

/*************************
 * @Machine: RedmiBook Pro 15 Win11
 * @Path: app/src/main/java/cn/barry/jetpackapp/pixabay/view
 * @Time: 2022/5/6 17:49
 * @Author: BarryAllen
 * @Description: PixabayAdapter
 * @formatter:off
 **************************/
class PixabayAdapter : BaseRvVBListAdapter<PixabayEntity_Child_Image, PixabayRvImageItemBinding>({ oldItem, newItem ->
    oldItem.id == newItem.id
}) {

    override fun getViewBinding(parent: ViewGroup) = PixabayRvImageItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

    override fun ViewHolder.initCreateViewHolder(parent: ViewGroup, viewType: Int){
        itemView.setOnClickListener {
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        with(holder){
            mBinding.pixabayRvItemShimmerLayout.apply {
                setShimmerColor(0x55FFFFFF)
                setShimmerAngle(0)
                startShimmerAnimation()
            }
            Glide.with(itemView)
                .load(getItem(position).preUrl)
                .placeholder(R.drawable.steve)
                .addListener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                        return false
                    }
                    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean{
                        return false.also { mBinding.pixabayRvItemShimmerLayout.stopShimmerAnimation() }
                    }
                })
                .into(mBinding.pixabayRvItemImageView)
        }
    }
}