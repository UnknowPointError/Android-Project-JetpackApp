package com.barry.base.network

import com.android.volley.*
import com.android.volley.toolbox.HttpHeaderParser
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import java.io.UnsupportedEncodingException
import java.nio.charset.Charset

/*************************
 * @Machine: RedmiBook Pro 15 Win11
 * @Path: lib_base/src/main/java/cn/barry/base/network
 * @Time: 2022/5/6 15:00
 * @Author: BarryAllen
 * @Description: VolleyExt
 * @formatter:off
 **************************/

class GsonRequest<T>(url: String,
    private val clazz: Class<T>,
    private val headers: MutableMap<String, String>?,
    private val listener: Response.Listener<T>,
    errorListener: Response.ErrorListener
) : Request<T>(Method.GET, url, errorListener) {

    private val gson = Gson()

    override fun getHeaders(): MutableMap<String, String> = headers ?: super.getHeaders()

    override fun deliverResponse(response: T) = listener.onResponse(response)

    override fun parseNetworkResponse(response: NetworkResponse?): Response<T> {
        return try {
            val json = String(response?.data ?: ByteArray(0), Charset.forName(HttpHeaderParser.parseCharset(response?.headers)))
            Response.success(gson.fromJson(json, clazz), HttpHeaderParser.parseCacheHeaders(response))
        }
        catch (e: UnsupportedEncodingException) { Response.error(ParseError(e)) }
        catch (e: JsonSyntaxException) { Response.error(ParseError(e)) }
    }
}
inline fun <reified T> volleyRequest(queue: RequestQueue,requestUrl: String, headers : MutableMap<String,String>? = null): Flow<T> {
    return callbackFlow<T> {
        val request = GsonRequest<T>(requestUrl, T::class.java, headers, {
            trySendBlocking(it)
                .onSuccess { close() }
                .onClosed { cause -> cancel(CancellationException(cause?.localizedMessage, cause)) }
                .onFailure { cause -> cancel(CancellationException(cause?.localizedMessage, cause)) }
        }, {
            cancel()
        })
        queue.add(request)
        awaitClose { request.cancel() }
    }
}