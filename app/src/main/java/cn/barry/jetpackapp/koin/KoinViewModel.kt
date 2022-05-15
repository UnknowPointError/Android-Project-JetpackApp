package cn.barry.jetpackapp.koin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cn.barry.base.viewmodel.BaseViewModel

/*************************
 * @ProjectName: JetpackApp
 * @Dir_Path: app/src/main/java/cn/barry/jetpackapp
 * @Time: 2022/2/21 1:07
 * @Author: BarryAllen
 * @Description:
 **************************/

class KoinViewModel(private val repo: KoinRepository) : BaseViewModel(){
    private val _count = MutableLiveData<Int>()
    val count: LiveData<Int> get() = _count

    fun sayHello() = "${repo.baseInterface.sayHello()} from $this"

    fun addCount() {
        _count.value = (_count.value ?: 0) + 1
    }
}