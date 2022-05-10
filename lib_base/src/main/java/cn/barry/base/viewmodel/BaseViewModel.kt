package cn.barry.base.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cn.barry.base.extensions.logger
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/*************************
 * @ProjectName: JetpackApp
 * @Dir_Path: lib_base/src/main/java/cn/barry/base/viewmodel
 * @Time: 2022/4/26 9:37
 * @Author: BarryAllen
 * @Description: ViewModel 父类
 **************************/
open class BaseViewModel : ViewModel() {

    private var _viewState = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState> get() = _viewState

    private var _volleyViewState = MutableLiveData<ViewState>()
    val volleyViewState: LiveData<ViewState> get() = _volleyViewState

    @PublishedApi
    internal var baseViewState: MutableLiveData<ViewState>
        get() = _viewState
        set(value) {
            _viewState = value
        }

    @PublishedApi
    internal var baseVolleyViewState: MutableLiveData<ViewState>
        get() = _volleyViewState
        set(value) {
            _volleyViewState = value
        }

    inline fun <T> flowLaunch(flow: Flow<T>, crossinline successBlock: (T) -> Unit) {
        viewModelScope.launch {
            runCatching {
                flow
                    .onStart { baseViewState.setState(ViewState.Loading) }
                    .onCompletion { cause -> if (cause == null) baseViewState.setState(ViewState.Success()) }
                    .catch { cause -> baseViewState.setState(ViewState.Error(msg = cause.localizedMessage)) }
                    .flowOn(Dispatchers.IO)
                    .collect { successBlock(it) }
            }.onFailure { cause -> baseViewState.setState(ViewState.Error(msg = cause.localizedMessage)) }
        }
    }

    inline fun <T> volleyFlowLaunch(flow: Flow<T>, crossinline succesBlock: (T) -> Unit) {
        viewModelScope.launch {
            runCatching {
                flow
                    .onStart { baseVolleyViewState.setState(ViewState.Loading) }
                    .onCompletion { cause -> if (cause == null) baseVolleyViewState.setState(ViewState.Success()) }
                    .catch { cause -> baseVolleyViewState.setState(ViewState.Error(msg = cause.localizedMessage)) }
                    .flowOn(Dispatchers.IO)
                    .collect { succesBlock(it) }
            }.onFailure { cause -> baseVolleyViewState.setState(ViewState.Error(msg = cause.localizedMessage)) }
        }
    }

    suspend fun MutableLiveData<ViewState>.setState(state: ViewState) {
        if (currentCoroutineContext() == Dispatchers.Main) this.value = state
        else this.postValue(state)
    }
}