package cn.barry.jetpackapp.baiduimage.view.activity

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cn.barry.base.extensions.logger
import cn.barry.base.viewmodel.BaseViewModel
import cn.barry.jetpackapp.baiduimage.model.response.BaiduImageAccessTokenEntity
import cn.barry.jetpackapp.baiduimage.model.BaiduImageRepository

/*************************
 * @Machine: RedmiBook Pro 15 Win11
 * @Path: app/src/main/java/cn/barry/jetpackapp/baiduimage
 * @Time: 2022/5/12 18:46
 * @Author: BarryAllen
 * @Description: BaiduImageViewModel
 **************************/
class BaiduImageNavigationViewModel(val repository: BaiduImageRepository) : BaseViewModel() {

    var token: String? = null

    val imagePath = mutableListOf<Uri>()
    val imageMapPath = mutableMapOf<String,MutableList<Uri>>()

    var adapterPositionFilterColor: MutableList<Int> = mutableListOf()

    val _tokenEntity = MutableLiveData<BaiduImageAccessTokenEntity>()
    val tokenEntity: LiveData<BaiduImageAccessTokenEntity> get() = _tokenEntity

    fun getAccessToken() {
        flowLaunch(repository.getAccessToken()) { accessTokenEntity ->
            _tokenEntity.value = accessTokenEntity
        }
    }
}