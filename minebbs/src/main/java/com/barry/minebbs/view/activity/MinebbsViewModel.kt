package com.barry.minebbs.view.activity

import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cn.barry.base.viewmodel.BaseViewModel
import com.barry.minebbs.TemplateEntity
import com.barry.minebbs.UserIconEntity
import com.barry.minebbs.model.MinebbsRepository
import com.barry.minebbs.model.ModelEntity
import com.barry.minebbs.view.adapter.body.UserIconBody

/*************************
 * @ProjectName: JetpackApp
 * @Dir_Path: app/src/main/java/cn/barry/jetpackapp/navigation
 * @Time: 2022/4/26 10:04
 * @Author: BarryAllen
 * @Description:
 **************************/
class MinebbsViewModel(private val reposiroty: MinebbsRepository) : BaseViewModel() {
    private val _templateEntityInfo = MutableLiveData<TemplateEntity>()
    val templateEntityInfo get() = _templateEntityInfo

    private val _userIconEntityInfo = MutableLiveData<UserIconEntity>()
    val userIconEntityInfo: LiveData<UserIconEntity> get() = _userIconEntityInfo

    val imageList : MutableList<UserIconBody> = mutableListOf()

    var id = 1

    var drawable : Drawable? = null

    fun getTemplateEntityInfo() = flowLaunch<ModelEntity.GET.TemplateEntity>(reposiroty.getTemplateEntity()) { _templateEntityInfo.value = it }

    fun getUserIconEntityInfo(id : Int) {
        flowLaunch(reposiroty.getUserIconEntity(id.toString())){
            imageList.add(UserIconBody(BitmapFactory.decodeStream(it.byteStream()),id))
            _userIconEntityInfo.value = it
            this.id++
        }
    }
}