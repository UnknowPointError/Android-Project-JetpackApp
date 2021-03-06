package cn.barry.jetpackapp.minebbs.view.adapter

import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import cn.barry.jetpackapp.R
import cn.barry.jetpackapp.databinding.MinebbsRecyclerviewUsericonItemBinding
import cn.barry.jetpackapp.minebbs.MinebbsConfig
import com.barry.base.adapter.BaseRvVBAdapter
import com.barry.base.app.appContext
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/*************************
 * @Machine: RedmiBook Pro 15 Win11
 * @Path: minebbs/src/main/java/com/barry/minebbs/view/adapter
 * @Time: 2022/5/3 13:54
 * @Author: BarryAllen
 * @Description: UserIconRvAdapter
 **************************/


class UserIconRvAdapter(val imageList : MutableList<Int>) : BaseRvVBAdapter<MinebbsRecyclerviewUsericonItemBinding>() {

    var itemViewCallback : ((mBinding: MinebbsRecyclerviewUsericonItemBinding) -> Unit)? = null
    var drawable : Drawable? = null

    override fun getViewBinding(parent: ViewGroup) = MinebbsRecyclerviewUsericonItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

    override fun onBindViewHolder(holder: BaseRvVBHolder, position: Int) {
        with(holder.mBinding) {
            val imageInfo = imageList[position]
            Glide.with(appContext)
                .load(MinebbsConfig.URL.plus("v1/avatar/$imageInfo"))
                .into(object : CustomTarget<Drawable>(){
                    override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                        drawable = resource
                        rvUserIconImageView.setImageDrawable(drawable)
                    }

                    override fun onLoadCleared(placeholder: Drawable?) {
                    }
                })
            rvUserIconTextView.text = imageInfo.toString()
        }
    }

    context(BaseRvVBHolder)
    override fun initCreateViewHolder() {
        itemView.setOnClickListener {
            itemViewCallback?.apply { (mBinding) }
        }
    }

    override fun getItemCount(): Int  = imageList.size

    fun getDrawables(): Drawable {
        CoroutineScope(Dispatchers.IO).launch {
            while (drawable != null) {
                delay(300L)
                drawable = null
                break
            }
        }
        /* https://blog.csdn.net/z784561257/article/details/81060842 */
        return drawable ?: ResourcesCompat.getDrawable(Resources.getSystem(), R.drawable.steve,null)!!
    }
}
