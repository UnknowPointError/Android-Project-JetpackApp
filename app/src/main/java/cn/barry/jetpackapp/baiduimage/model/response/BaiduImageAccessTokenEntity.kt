package cn.barry.jetpackapp.baiduimage.model.response

import com.google.gson.annotations.SerializedName

/*************************
 * @Machine: RedmiBook Pro 15
 * @RelativePath: cn\barry\jetpackapp\baiduimage\model\AccessTokenEntity.kt
 * @Path: D:\Barry\B_study\Android\Android_Project\JetpackApp\app\src\main\java\cn\barry\jetpackapp\baiduimage\model\AccessTokenEntity.kt
 * @Author: Barry
 * @Time: 2022/5/12 18:56 周四 下午
 * @Description: 获取Access Token
 * @formatter:off
 *************************/

data class BaiduImageAccessTokenEntity(

    /* Token */
    @SerializedName("access_token")
    val token: String,

    /* Token有效期 */
    @SerializedName("expires_in")
    val tokenExpiresTime: String
)