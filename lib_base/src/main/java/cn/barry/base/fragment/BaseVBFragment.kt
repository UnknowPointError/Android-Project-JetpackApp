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
import cn.barry.base.extensions.toast
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

    protected var isNeedLazy = false
    protected var lazyTime = 300L
    private val mHandler : Handler = Handler(Looper.getMainLooper())
    private var _mBinding: VB? = null
    protected val mBinding get() = _mBinding!!
    protected val mViewModel by lazy { getViewModel().value }

    abstract fun getViewBinding(inflater: LayoutInflater): VB
    abstract fun getViewModel(): Lazy<VM>
    abstract fun init(view:View,savedInstanceState: Bundle?)

    open fun lazyData() { }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        _mBinding = getViewBinding(inflater)
        return mBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view,savedInstanceState)
        mViewModel.viewState.observe(viewLifecycleOwner) { viewState ->
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
        if(!isHidden && isNeedLazy) mHandler.postDelayed({ lazyData() },lazyTime)
    }
    override fun onDestroyView(){
        super.onDestroyView()
        _mBinding = null
    }
}