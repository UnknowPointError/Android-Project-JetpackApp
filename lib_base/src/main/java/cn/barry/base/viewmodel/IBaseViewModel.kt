package cn.barry.base.viewmodel

import androidx.lifecycle.LiveData


/*************************
 * @ProjectName: JetpackApp
 * @Dir_Path: lib_base/src/main/java/cn/barry/base/viewmodel
 * @Time: 2022/4/26 9:37
 * @Author: BarryAllen
 * @Description: BaseViewModel 接口类
 **************************/
interface IBaseViewModel {
    val viewState: LiveData<ViewState>
}
