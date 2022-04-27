package cn.barry.base.activity

/*************************
 * @ProjectName: JetpackApp
 * @Dir_Path: lib_base/src/main/java/cn/barry/base/activity
 * @Time: 2022/4/26 9:34
 * @Author: BarryAllen
 * @Description: Activity接口父类
 **************************/
interface IBaseActivity {

    /* 显示加载动画 */
    fun showLoadingAnim()

    /* 隐藏加载动画 */
    fun dismissLoadingAnim()
}