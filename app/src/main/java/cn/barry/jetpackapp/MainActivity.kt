package cn.barry.jetpackapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cn.barry.base.startActivity
import cn.barry.base.toast
import cn.barry.jetpackapp.databinding.ActivityMainBinding
import cn.barry.jetpackapp.koin.KoinActivity
import cn.barry.jetpackapp.koin.MySimplePresenter
import cn.barry.jetpackapp.koin.MyViewModel
import cn.barry.jetpackapp.koin.SingleClass
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    // Lazy injected MySimplePresenter
    private val firstPresenter: MySimplePresenter by inject()

    // Lazy Inject ViewModel
    private val myViewModel: MyViewModel by viewModel()
    private val mBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val app: SingleClass by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        title = "MainActivity"
        mBinding.textView.text = firstPresenter.sayHello()
        app.count++
        app.count.toString().toast()
        firstPresenter.sayHello()
        mBinding.nextActivity.setOnClickListener {
            startActivity<KoinActivity>()
            overridePendingTransition(R.anim.anim_in, R.anim.anim_out)
        }
    }
}
