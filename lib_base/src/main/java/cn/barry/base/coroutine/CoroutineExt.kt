package cn.barry.base.coroutine

import cn.barry.base.extensions.logInfo
import kotlinx.coroutines.*
import okhttp3.internal.wait

/*************************
 * @Machine: RedmiBook Pro 15 Win11
 * @Path: lib_base/src/main/java/cn/barry/base/coroutine
 * @Time: 2022/5/5 9:02
 * @Author: BarryAllen
 * @Description: Coroutine Ext
 **************************/

val ioCoroutine = CoroutineScope(Dispatchers.IO)
val uiCoroutine = CoroutineScope(Dispatchers.Main)
val defaultCoroutine = CoroutineScope(Dispatchers.Default)

fun ioLaunch(block : suspend () -> Unit) { ioCoroutine.launch { block() } }
fun uiLaunch(block : suspend () -> Unit) { uiCoroutine.launch { block() } }