package com.barry.minebbs.model

import com.barry.minebbs.TemplateEntity_Flow
import com.barry.minebbs.UserIconEntity_Flow
import com.barry.minebbs.network.ModelService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.ResponseBody

/*************************
 * @Machine: RedmiBook Pro 15
 * @RelativePath: com\barry\minebbs\model\MinebbsRepository.kt
 * @Path: D:\Barry\B_study\Android\Android_Project\JetpackApp\minebbs\src\main\java\com\barry\minebbs\model\MinebbsRepository.kt
 * @Author: Barry
 * @Time: 2022/5/1 16:36 周日 下午
 * @Description:
 *************************/

class MinebbsRepository(private val modelService: ModelService) {

    fun getTemplateEntity() : TemplateEntity_Flow = modelService.getTemplate().flowOn(Dispatchers.IO)

    fun getUserIconEntity(id: String) : UserIconEntity_Flow = modelService.getUserIcon(id).flowOn(Dispatchers.IO)

}