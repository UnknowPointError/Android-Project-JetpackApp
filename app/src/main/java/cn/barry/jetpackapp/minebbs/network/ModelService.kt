package cn.barry.jetpackapp.minebbs.network

import cn.barry.jetpackapp.minebbs.TemplateEntity_Flow
import cn.barry.jetpackapp.minebbs.MinebbsConfig
import cn.barry.jetpackapp.minebbs.UserIconEntity_Flow
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