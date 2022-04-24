package cn.barry.jetpackapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.viewModelScope
import cn.barry.base.startActivity
import cn.barry.base.toast
import cn.barry.jetpackapp.databinding.ActivityMainBinding
import cn.barry.jetpackapp.koin.*
import cn.barry.jetpackapp.lifecycle.LifeCycleActivity
import cn.barry.jetpackapp.livedata.LiveDataActivity
import cn.barry.jetpackapp.material.MaterialActivity
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {


    // Lazy injected MySimplePresenter
    private val firstPresenter: MySimplePresenter by inject()

    // Lazy Inject ViewModel
    private val myViewModel: MyViewModel by viewModel()
    private val mBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val app: SingleClass by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        initView()
        initEvent()
    }

    private fun initEvent() = with(mBinding.buttonLayout) {
        buttonKoinActivity.setOnClickListener(this@MainActivity)
        buttonLifecycle.setOnClickListener(this@MainActivity)
        buttonLivedata.setOnClickListener(this@MainActivity)
        buttonMaterial.setOnClickListener(this@MainActivity)
    }

    private fun initView() {
        title = "MainActivity"
    }

    override fun onClick(v: View?) {
        with(mBinding.buttonLayout) {
            when (v?.id) {
                buttonKoinActivity.id -> {
                    /* app属性使用了by inject()是什么意思？
                     by inject()是Koin的一个函数，它的作用是将某个类的实例注入到Koin的容器中，
                     并且返回该实例，这样就可以在Koin的容器中获取该类的实例了。*/
                    startActivity<KoinActivity> { }
                    overridePendingTransition(R.anim.anim_in, R.anim.anim_out)
                    app.count++
                    firstPresenter.sayHello()
                }
                buttonLifecycle.id -> {
                    startActivity<LifeCycleActivity> { }
                }
                buttonLivedata.id -> {
                    startActivity<LiveDataActivity> { }
                }
                buttonMaterial.id -> {
                    startActivity<MaterialActivity> {  }
                }
                else -> {}
            }
        }
    }
}
