package cn.barry.jetpackapp.koin

/*************************
 * @ProjectName: JetpackApp
 * @Dir_Path: app/src/main/java/cn/barry/jetpackapp
 * @Time: 2022/2/21 1:06
 * @Author: BarryAllen
 * @Description:
 **************************/
interface HelloRepository {
    fun giveHello(): String
}

class HelloRepositoryImpl() : HelloRepository {
    override fun giveHello() = "Hello Koin"
}