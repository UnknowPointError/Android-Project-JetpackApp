package com.barry.base.extensions

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/*************************
 * @Machine: RedmiBook Pro 15 Win11
 * @Path: lib_base/src/main/java/cn/barry/base/network
 * @Time: 2022/5/1 13:54
 * @Author: BarryAllen
 * @Description: Flow扩展
 * @formatter:off
 **************************/

/* 异步请求 */
internal fun <R> ProducerScope<R>.callEnquenFlow(call: Call<R>) {
    call.enqueue(object : Callback<R> {
        override fun onResponse(call: Call<R>, response: Response<R>) {
            if (response.isSuccessful) {
                val body = response.body()
                if (body == null || response.body() == 204) cancel(CancellationException("Http status code: ${response.code()}"))
                else {
                    trySendBlocking(body)
                        .onSuccess { close() }
                        .onClosed { cancel(CancellationException(it?.localizedMessage, it)) }
                        .onFailure { cancel(CancellationException(it?.localizedMessage, it)) }
                }
            } else {
                val msg = response.errorBody()?.string()
                cancel(CancellationException((if (msg.isNullOrEmpty()) response.message() else msg) ?: "Unknow error"))
            }
        }

        override fun onFailure(call: Call<R>, t: Throwable) {
            close(t)
        }
    })
}