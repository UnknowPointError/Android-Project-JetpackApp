package com.barry.minebbs.network

import com.barry.minebbs.TemplateEntity_Flow
import com.barry.minebbs.MinebbsConfig
import com.barry.minebbs.UserIconEntity_Flow
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/*************************
 * @ProjectName: JetpackApp
 * @Dir_Path: minebbs/src/main/java/com/barry/minebbs/network
 * @Time: 2022/4/27 14:30
 * @Author: BarryAllen
 * @Description: ModelService
 **************************/
interface ModelService {

    /* 响应模板 */
    @GET(MinebbsConfig.Url_Get_Response_Template)
    fun getTemplate() : TemplateEntity_Flow

    @GET(MinebbsConfig.Url_Get_UserIcon)
    fun getUserIcon(@Path("id") id: String) : UserIconEntity_Flow

}