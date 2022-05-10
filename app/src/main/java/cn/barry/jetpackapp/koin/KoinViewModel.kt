package cn.barry.jetpackapp.koin

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
    var count = 0

    fun sayHello() = "${repo.baseInterface.sayHello()} from $this"
}