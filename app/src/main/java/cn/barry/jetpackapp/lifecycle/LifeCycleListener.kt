package cn.barry.jetpackapp.lifecycle

import android.util.Log
import androidx.lifecycle.*

/*************************
 * @ProjectName: JetpackApp
 * @Dir_Path: app/src/main/java/cn/barry/jetpackapp/lifecycle
 * @Time: 2022/4/21 9:46
 * @Author: BarryAllen
 * @Description:
 **************************/
class LifeCycleListener() : DefaultLifecycleObserver {

    private val lifecycleTag = "LifeCycle"

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Log.d(lifecycleTag, "onStart: ")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.d(lifecycleTag, "onResume: ")
    }


    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.d(lifecycleTag, "onCreate: ")
        if (owner.lifecycle.currentState.isAtLeast(Lifecycle.State.CREATED)) {

        }
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.d(lifecycleTag, "onPause: ")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.d(lifecycleTag, "onStop: ")
    }
}
