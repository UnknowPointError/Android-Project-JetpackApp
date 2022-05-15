package cn.barry.jetpackapp.baiduimage.model.response

import com.google.gson.annotations.SerializedName

/*************************
 * @Machine: RedmiBook Pro 15 Win11
 * @Path: app/src/main/java/cn/barry/jetpackapp/baiduimage/model/entity
 * @Time: 2022/5/12 21:24
 * @Author: BarryAllen
 * @Description: BaiduImageAddImageEntity
 **************************/
data class BaiduImageAddImageEntity(
    /* 唯一的log id，无实际意义，用于问题定位 */
    @SerializedName("log_id")
    val questionId: Any,

    /* 输入图片的签名信息，请务必保存至本地，以便后续用作批量删除、查询某张图是否已经入过库等用途 */
    @SerializedName("cont_sign")
    val contentSign: String
)