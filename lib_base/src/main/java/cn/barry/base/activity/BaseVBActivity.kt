package cn.barry.base.activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import cn.barry.base.dialog.LoadingAnimDialog
import cn.barry.base.extensions.logger
import cn.barry.base.extensions.toast
import cn.barry.base.viewmodel.BaseViewModel
import cn.barry.base.viewmodel.doOnError
import cn.barry.base.viewmodel.doOnLoading
import cn.barry.base.viewmodel.doOnSuccess
import com.orhanobut.logger.Logger

/*************************
 * @ProjectName: JetpackApp
 * @Dir_Path: lib_base/src/main/java/cn/barry/base/activity
 * @Time: 2022/4/26 9:32
 * @Author: BarryAllen
 * @Description: BaseViewBindingActivity 父类
 * @formatter:off
 **************************/
abstract class BaseVBActivity<VB : ViewBinding,VM : BaseViewModel> : AppCompatActivity(){

    protected val mHandler: Handler = Handler(Looper.getMainLooper())
    protected var mIsNeedLazy : Boolean = false
    protected var mIsNeedNetWorkLoading: Boolean = false
    protected var mLazyTime : Long = 300L
    protected val mBinding: VB by lazy { getViewBinding() }
    protected val mViewModel by lazy { getViewModel().value }

    abstract fun getViewBinding(): VB
    abstract fun getViewModel(): Lazy<VM>
    abstract fun doInitOnCreate(savedInstanceState: Bundle?)

    /* 根据函数名规范使用 */
    open fun lazyData() { }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutInflater
        setContentView(mBinding.root)
        if (mIsNeedNetWorkLoading) mViewModel.viewState.observe(this) { viewState ->
            viewState
                .doOnLoading { LoadingAnimDialog.show(supportFragmentManager) }
                .doOnSuccess { LoadingAnimDialog.dismiss(supportFragmentManager) }
                .doOnError { _, msg ->
                    mHandler.postDelayed({
                        LoadingAnimDialog.dismiss(supportFragmentManager)
                        "网络异常！".toast(false)
                    },1_000)
                    if (msg?.isNotBlank() == true) {
                        msg.logger(Logger.ERROR)
                    }
                }
        }
        doInitOnCreate(savedInstanceState)
    }
    override fun onResume() {
        super.onResume()
        if(mIsNeedLazy) mHandler.postDelayed({ lazyData() },mLazyTime)
    }
}