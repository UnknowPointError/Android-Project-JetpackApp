package cn.barry.jetpackapp.baiduimage.model.request

import com.google.gson.annotations.SerializedName

/*************************
 * @Machine: RedmiBook Pro 15 Win11
 * @Path: app/src/main/java/cn/barry/jetpackapp/baiduimage/model/request
 * @Time: 2022/5/12 21:31
 * @Author: BarryAllen
 * @Description: BaiduImageAddImageBody
 **************************/
data class BaiduImageAddImageBody(
    @SerializedName("image")
    val imageData: String? = null,

    @SerializedName("url")
    val imageUrl: String? = null,

    @SerializedName("brief")
    val imageInfo: String,

    @SerializedName("tags")
    val imageTag: String
)

