package com.barry.base.network

import com.barry.base.extensions.callEnquenFlow
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

/*************************
 * @Machine: RedmiBook Pro 15 Win11
 * @Path: lib_base/src/main/java/cn/barry/base/network
 * @Time: 2022/5/1 13:53
 * @Author: BarryAllen
 * @Description:
 **************************/
class FlowCallAdapter<R>(private val responseType: Type) : CallAdapter<R, Flow<R?>> {

    override fun responseType(): Type = responseType

    override fun adapt(call: Call<R>): Flow<R?> {
        return callbackFlow<R> {
            callEnquenFlow(call)
            awaitClose { call.cancel() }
        }
    }
}