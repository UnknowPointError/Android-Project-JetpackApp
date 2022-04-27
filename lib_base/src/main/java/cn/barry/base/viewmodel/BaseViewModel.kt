package cn.barry.base.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

/*************************
 * @ProjectName: JetpackApp
 * @Dir_Path: lib_base/src/main/java/cn/barry/base/viewmodel
 * @Time: 2022/4/26 9:37
 * @Author: BarryAllen
 * @Description: ViewModel 父类
 **************************/
open class BaseViewModel : ViewModel(), IBaseViewModel {
    private var _viewState = MutableLiveData<ViewState>()
    override val viewState: LiveData<ViewState> get() = _viewState

    @PublishedApi
    internal var baseViewState: MutableLiveData<ViewState>
        get() = _viewState
        set(value) {
            _viewState = value
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
            }.onFailure {
                baseViewState.setState(ViewState.Error(msg = it.localizedMessage))
            }
        }
    }

    suspend fun MutableLiveData<ViewState>.setState(state: ViewState) {
        if (currentCoroutineContext() == Dispatchers.Main) this.value = state
        else this.postValue(state)
    }

}