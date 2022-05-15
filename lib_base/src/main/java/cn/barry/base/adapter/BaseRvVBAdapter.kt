package cn.barry.base.adapter

import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/*************************
 * @Machine: RedmiBook Pro 15 Win11
 * @Path: lib_base/src/main/java/cn/barry/base/adapter
 * @Time: 2022/5/3 14:25
 * @Author: BarryAllen
 * @Description: BaseRvAdapter
 **************************/
abstract class BaseRvVBAdapter<VB : ViewBinding>() : RecyclerView.Adapter<BaseRvVBAdapter<VB>.BaseRvVBHolder>() {

    inner class BaseRvVBHolder(val mBinding : VB) : RecyclerView.ViewHolder(mBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= BaseRvVBHolder(getViewBinding(parent)).also { it.initCreateViewHolder() }

    abstract fun getViewBinding(parent: ViewGroup) : VB

    open fun BaseRvVBHolder.initCreateViewHolder() {  }
}
