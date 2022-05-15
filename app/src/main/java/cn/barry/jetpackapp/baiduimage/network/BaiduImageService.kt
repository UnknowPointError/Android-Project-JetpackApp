package cn.barry.jetpackapp.baiduimage.network

import cn.barry.jetpackapp.baiduimage.BaiduImageAccessTokenEntity_Flow
import cn.barry.jetpackapp.baiduimage.BaiduImageAddImageEntity_Flow
import cn.barry.jetpackapp.baiduimage.BaiduImageConfig
import cn.barry.jetpackapp.baiduimage.model.request.BaiduImageAddImageBody
import retrofit2.http.Body
import retrofit2.http.POST

/*************************
 * @Machine: RedmiBook Pro 15 Win11
 * @Path: app/src/main/java/cn/barry/jetpackapp/baiduimage/network
 * @Time: 2022/5/12 19:01
 * @Author: BarryAllen
 * @Description: BaiduImageServices
 **************************/
interface BaiduImageService {

    @POST("oauth/2.0/token?grant_type=client_credentials&client_id=${BaiduImageConfig.API_KEY}&client_secret=${BaiduImageConfig.SECRET_KEY}&")
    fun getAccessToken(): BaiduImageAccessTokenEntity_Flow

    @POST("rest/2.0/image-classify/v1/realtime_search/similar/add")
    fun addImageToDataBase(@Body addImageEntity: BaiduImageAddImageBody): BaiduImageAddImageEntity_Flow
}