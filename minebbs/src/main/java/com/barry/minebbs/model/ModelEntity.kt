package com.barry.minebbs.model

import com.google.gson.annotations.SerializedName

/*
@Machine: RedmiBook Pro 15
@Author: Barry
@Time: 2022/4/12 21:06 周二 下午
@Description: MineBBS模型数据
*/

object ModelEntity {
    object GET {

        data class BaseEntity(

            /* 请求是否成功 */
            @SerializedName("success")
            val isSuccess: Boolean?,

            /* 状态码 */
            @SerializedName("status")
            val codeStatus: Int?,

            /* 返回信息 */
            @SerializedName("message")
            val message: String?,

            /* API版本 */
            @SerializedName("version")
            val ApiVersion: String?,

            /* API代号 */
            @SerializedName("codename")
            val ApiCodeName: String?,

            /* 当前时间戳 */
            @SerializedName("time")
            val currentTime: Long?,

            /* 数据 */
            @SerializedName("data")
            val data: MutableList<Any>?,
        )

    }

    object POST {

    }
}