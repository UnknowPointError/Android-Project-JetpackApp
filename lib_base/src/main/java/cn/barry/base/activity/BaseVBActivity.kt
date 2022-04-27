package cn.barry.base.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import cn.barry.base.toast
import cn.barry.base.viewmodel.BaseViewModel
import cn.barry.base.viewmodel.doOnError
import cn.barry.base.viewmodel.doOnLoading
import cn.barry.base.viewmodel.doOnSuccess

/*************************
 * @ProjectName: JetpackApp
 * @Dir_Path: lib_base/src/main/java/cn/barry/base/activity
 * @Time: 2022/4/26 9:32
 * @Author: BarryAllen
 * @Description: BaseViewBindingActivity 父类
 * @formatter:off
 **************************/
abstract class BaseVBActivity<out VB : ViewBinding, out VM : BaseViewModel> : AppCompatActivity(), IBaseActivity {

    /* @formatter:on */
    protected val mBinding get() = _mBinding
    private val _mBinding by lazy { getViewBinding() }
    private val viewModel by lazy { getViewModel().value }
    abstract fun init(savedInstanceState : Bundle?)
    abstract fun getViewBinding(): VB
    abstract fun getViewModel(): Lazy<VM>


    override fun showLoadingAnim() {}
    override fun dismissLoadingAnim() {}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(_mBinding.root)
        init(savedInstanceState)
        initObserver()
    }

    private fun initObserver() {
        viewModel.viewState.observe(this) { viewState ->
            viewState
                .doOnLoading { showLoadingAnim() }
                .doOnSuccess { dismissLoadingAnim() }
                .doOnError { type, msg ->
                    dismissLoadingAnim()
                    if (msg?.isNotBlank() == true) msg.toast()
                }
        }
    }

}