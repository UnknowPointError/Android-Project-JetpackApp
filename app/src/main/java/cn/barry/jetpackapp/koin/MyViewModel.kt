package cn.barry.jetpackapp.koin

import androidx.lifecycle.ViewModel

/*************************
 * @ProjectName: JetpackApp
 * @Dir_Path: app/src/main/java/cn/barry/jetpackapp/koin
 * @Time: 2022/3/4 11:01
 * @Author: BarryAllen
 * @Description:
 **************************/
class MyViewModel(val repo: HelloRepository) : ViewModel() {
    fun sayHello() = "${repo.giveHello()} from $this"
}