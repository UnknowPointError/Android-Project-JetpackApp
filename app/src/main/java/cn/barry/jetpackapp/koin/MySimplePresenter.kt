package cn.barry.jetpackapp.koin

/*************************
 * @ProjectName: JetpackApp
 * @Dir_Path: app/src/main/java/cn/barry/jetpackapp
 * @Time: 2022/2/21 1:07
 * @Author: BarryAllen
 * @Description:
 **************************/

class MySimplePresenter(val repo: HelloRepository) {
    fun sayHello() = "${repo.giveHello()} from $this"
}