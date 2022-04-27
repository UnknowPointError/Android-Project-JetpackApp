package com.barry.minebbs.model

import com.barry.minebbs.network.ModelService
import retrofit2.Call

/*
@Machine: RedmiBook Pro 15
@RelativePath: com\barry\minebbs\model\Repository.kt
@Path: D:\Barry\B_study\Android\Android_Project\JetpackApp\minebbs\src\main\java\com\barry\minebbs\model\Repository.kt
@Author: Barry
@Time: 2022/4/27 14:31 周三 下午
@Description:
*/

class Repository(private val modelService: ModelService) {

    fun getBaseEntity() : Call<ModelEntity.GET.BaseEntity> = modelService.getBaseEntity()

}