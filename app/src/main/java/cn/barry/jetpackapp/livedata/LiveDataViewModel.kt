package cn.barry.jetpackapp.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/*************************
 * @ProjectName: JetpackApp
 * @Dir_Path: app/src/main/java/cn/barry/jetpackapp/livedata
 * @Time: 2022/4/21 22:55
 * @Author: BarryAllen
 * @Description:
 **************************/
class LiveDataViewModel : ViewModel() {

    private val _number = MutableLiveData<Int>()

    val number: LiveData<Int> get() = _number

    fun addNum() {
        _number.value = (_number.value ?: 0) + 1
    }

    fun clearNum() {
        _number.value = 0
    }
}