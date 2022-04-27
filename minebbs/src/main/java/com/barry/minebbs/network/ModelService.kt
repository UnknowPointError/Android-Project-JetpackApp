package com.barry.minebbs.network

import MineBBS.MINEBBS_CONFIG
import com.barry.minebbs.model.ModelEntity
import retrofit2.Call
import retrofit2.http.GET

/*************************
 * @ProjectName: JetpackApp
 * @Dir_Path: minebbs/src/main/java/com/barry/minebbs/network
 * @Time: 2022/4/27 14:30
 * @Author: BarryAllen
 * @Description: ModelService
 **************************/
interface ModelService {

    @GET(MINEBBS_CONFIG.BASE_URL_API_VERSION)
    fun getBaseEntity() : Call<ModelEntity.GET.BaseEntity>

}