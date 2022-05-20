package com.barry.base.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.annotation.FloatRange
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding

/*************************
 * @Machine: RedmiBook Pro 15
 * @RelativePath: cn\barry\base\dialog\BaseVBDialogFragment.kt
 * @Path: D:\Barry\B_study\Android\Android_Project\JetpackApp\lib_base\src\main\java\cn\barry\base\dialog\BaseVBDialogFragment.kt
 * @Author: Barry
 * @Time: 2022/5/2 9:41 周一 上午
 * @Description: 继承此Dialog等待有需要即可进行扩展
 * @formatter:off
 *************************/

abstract class BaseVBDialogFragment<out VB: ViewBinding>: DialogFragment() {

    companion object { val DIALOG_TAG: String = this::class.java.simpleName }
    private var window : Window? = null
    private var mDialogWidth = ViewGroup.LayoutParams.WRAP_CONTENT.toFloat()
    private var mDialogHeight = ViewGroup.LayoutParams.WRAP_CONTENT.toFloat()
    private var _mBinding: VB? = null
    protected val mBinding: VB get() = _mBinding!!

    abstract fun getViewBind(layoutInflater: LayoutInflater): VB

    /* 重写onStart并在内部使用 */
    protected fun setWidth(@FloatRange(from = 0.0, to = 1.0) size: Float) { this.mDialogWidth = size }
    protected fun setHeight(@FloatRange(from = 0.0, to = 1.0) size: Float) { this.mDialogHeight = size }
    protected fun setIsCancelable(isCancele : Boolean) { isCancelable = isCancele }
    protected fun setBackgroundTransparent() = window?.setBackgroundDrawableResource(android.R.color.transparent)
    protected fun setMaskAmount(amount: Float) = window?.setDimAmount(amount)


    /* Dialog视图宽高设置 */
    override fun onStart() {
        super.onStart()
        /* 设置百分比宽高 */
        window = dialog?.window
        requireActivity().resources.displayMetrics.let {
            window?.setLayout(
                if (mDialogWidth >= 0) (it.widthPixels * mDialogWidth).toInt() else ViewGroup.LayoutParams.WRAP_CONTENT,
                if (mDialogHeight >= 0) (it.widthPixels * mDialogHeight).toInt() else ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }
    }

    /* 创建Dialog所需的fragment视图 */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return getViewBind(inflater).also { _mBinding = it }.root
    }

    /* 销毁fragment所包的View组件时将_mBinding以及window置空 */
    override fun onDestroyView() {
        super.onDestroyView()
        _mBinding = null
        window = null
    }
}