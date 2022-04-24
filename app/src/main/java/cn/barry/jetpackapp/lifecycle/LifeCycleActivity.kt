package cn.barry.jetpackapp.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.ViewModelProvider
import cn.barry.jetpackapp.databinding.ActivityLifecycleBinding

class LifeCycleActivity : AppCompatActivity() {

    private val mBinding by lazy { ActivityLifecycleBinding.inflate(layoutInflater) }
    private val mLifeCycleRegistry : LifecycleRegistry by lazy { LifecycleRegistry(this) }
    private lateinit var viewModel: LifeCycleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        viewModel = ViewModelProvider(this).get(LifeCycleViewModel::class.java)
        lifecycle.addObserver(LifeCycleListener())
    }

    override fun onDestroy() {
        super.onDestroy()
        mLifeCycleRegistry.currentState = Lifecycle.State.DESTROYED
        Log.d("LifeCycle", "onDestroyed: ")
    }

}