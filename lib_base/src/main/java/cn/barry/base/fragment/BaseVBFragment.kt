package cn.barry.base.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import cn.barry.base.dialog.LoadingAnimDialog
import cn.barry.base.extensions.logError
import cn.barry.base.viewmodel.BaseViewModel
import cn.barry.base.viewmodel.doOnError
import cn.barry.base.viewmodel.doOnLoading
import cn.barry.base.viewmodel.doOnSuccess

/*************************
 * @Machine: RedmiBook Pro 15 Win11
 * @Path: lib_base/src/main/java/cn/barry/base/fragment
 * @Time: 2022/5/3 9:04
 * @Author: BarryAllen
 * @Description: BaseVBFragment
 * @formatter:off
 **************************/
abstract class BaseVBFragment<out VB : ViewBinding, out VM : BaseViewModel> : Fragment() {

    protected var mIsNeedNetworkLoading = false
    protected var mIsNeedLazy = false
    protected var mHandler : Handler? = Handler(Looper.getMainLooper())
    protected var mLazyTime = 300L
    protected val mViewModel by lazy { getViewModel().value }
    protected val mBinding get() = _mBinding!!
    private var _mBinding: VB? = null

    abstract fun getViewBinding(inflater: LayoutInflater): VB
    abstract fun getViewModel(): Lazy<VM>
    abstract fun doOnInitViewCreate(view:View,savedInstanceState: Bundle?)

    open fun lazyData() { }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        _mBinding = getViewBinding(inflater)
        return mBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        doOnInitViewCreate(view,savedInstanceState)
        if (mIsNeedNetworkLoading) mViewModel.viewState.observe(viewLifecycleOwner) { viewState ->
            viewState
                .doOnLoading { LoadingAnimDialog.show(parentFragmentManager) }
                .doOnSuccess { LoadingAnimDialog.dismiss(parentFragmentManager) }
                .doOnError { _, msg ->
                    LoadingAnimDialog.dismiss(parentFragmentManager)
                    if (!msg.isNullOrBlank()) msg.logError()
                }
        }
    }
    override fun onResume(){
        super.onResume()
        if(!isHidden && mIsNeedLazy) mHandler?.postDelayed({ lazyData() },mLazyTime)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _mBinding = null
        mHandler = null
    }
}