package cn.barry.base.activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import cn.barry.base.dialog.LoadingAnimDialog
import cn.barry.base.extensions.toast
import cn.barry.base.viewmodel.BaseViewModel
import cn.barry.base.viewmodel.doOnError
import cn.barry.base.viewmodel.doOnLoading
import cn.barry.base.viewmodel.doOnSuccess
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

/*************************
 * @ProjectName: JetpackApp
 * @Dir_Path: lib_base/src/main/java/cn/barry/base/activity
 * @Time: 2022/4/26 9:32
 * @Author: BarryAllen
 * @Description: BaseViewBindingActivity 父类
 * @formatter:off
 **************************/
abstract class BaseVBActivity<VB : ViewBinding,VM : BaseViewModel> : AppCompatActivity() {

    private val mHandler : Handler = Handler(Looper.getMainLooper())
    protected var isNeedLazy : Boolean = false
    protected var lazyTime : Long = 300L
    protected val mBinding: VB by lazy { getViewBinding() }
    protected val mViewModel by lazy { getViewModel().value }

    abstract fun getViewBinding(): VB
    abstract fun getViewModel(): Lazy<VM>
    abstract fun init(savedInstanceState: Bundle?)

    open fun lazyData() { }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        init(savedInstanceState)
        mViewModel.viewState.observe(this) { viewState ->
            viewState
                .doOnLoading { LoadingAnimDialog.show(supportFragmentManager) }
                .doOnSuccess { LoadingAnimDialog.dismiss(supportFragmentManager) }
                .doOnError { _, msg ->
                    LoadingAnimDialog.dismiss(supportFragmentManager)
                    if (msg?.isNotBlank() == true) msg.toast()
                }
        }
    }
    override fun onResume() {
        super.onResume()
        if(isNeedLazy) mHandler.postDelayed({ lazyData() },lazyTime)
    }
}