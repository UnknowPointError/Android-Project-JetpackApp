package cn.barry.jetpackapp.baiduimage.view.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import com.barry.base.adapter.BaseRvVBAdapter
import com.barry.base.app.appContext
import com.barry.base.extensions.log
import cn.barry.jetpackapp.databinding.AlbumBottomsheetdialogRvItemBinding
import com.bumptech.glide.Glide

/*************************
 * @Machine: RedmiBook Pro 15 Win11
 * @Path: app/src/main/java/cn/barry/jetpackapp/baiduimage/view/adapter
 * @Time: 2022/5/17 19:35
 * @Author: BarryAllen
 * @Description: BaiduImageMotionAdapter
 **************************/
class BaiduSelectAlbumAdapter(val imageList: Map<String,List<Uri>>): BaseRvVBAdapter<AlbumBottomsheetdialogRvItemBinding>() {
    private val layoutParam = FrameLayout.LayoutParams(appContext.resources.displayMetrics.widthPixels / 4,appContext.resources.displayMetrics.heightPixels / 8)
    override fun getViewBinding(parent: ViewGroup) = AlbumBottomsheetdialogRvItemBinding.inflate(LayoutInflater.from(parent.context))
    context(BaseRvVBHolder) override fun initCreateViewHolder() {
        "asdasd".log()
    }
    override fun onBindViewHolder(holder: BaseRvVBHolder, position: Int) {
        "    imageList.key".log()
        holder.mBinding.apply {
            albumMotionRvImage.layoutParams = layoutParam
            imageList.entries.forEach { imageList ->
                albumMotionRvTextView.text = imageList.key
                Glide.with(appContext)
                    .load(imageList.value[0])
                    .into(albumMotionRvImage)
            }
        }
    }

    override fun getItemCount(): Int = imageList.size
}