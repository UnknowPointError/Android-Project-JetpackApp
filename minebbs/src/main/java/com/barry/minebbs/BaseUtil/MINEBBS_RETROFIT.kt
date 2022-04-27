package MineBBS.BaseUtil

import MineBBS.MINEBBS_CONFIG
import android.util.Log
import cn.barry.base.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

object MINEBBS_RETROFIT {
    private val retrofit = Retrofit.Builder()
        .baseUrl(MINEBBS_CONFIG.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(servicesClass: Class<T>): T = retrofit.create(servicesClass)

    suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    Log.e("TAG_ERROR", "onResponse: ", )
                    body?.toString()?.toast()
                    if (body != null) continuation.resume(body)
                    else continuation.resumeWithException(
                        RuntimeException("body is null.")
                    )
                }
                override fun onFailure(call: Call<T>, t: Throwable) {
                continuation.resumeWithException(t)
                    Log.e("TAG_ERROR", "onResponse:sss ", )
                    t.localizedMessage?.toast()
                }
            })
        }
    }
}