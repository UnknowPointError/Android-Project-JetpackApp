package com.barry.base.extensions

import android.util.Log
import android.view.View
import android.widget.Toast
import com.barry.base.app.appContext
import com.google.android.material.snackbar.Snackbar
import com.orhanobut.logger.Logger

/*************************
 * @Machine: RedmiBook Pro 15
 * @RelativePath: cn\barry\base\extensions\TipExt.kt
 * @Path: D:\Barry\B_study\Android\Android_Project\JetpackApp\lib_base\src\main\java\cn\barry\base\extensions\TipExt.kt
 * @Author: Barry
 * @Time: 2022/5/1 20:58 周日 下午
 * @Description: Tips Ext
 * @formatter:off
 *************************/

/* 日志输出 */
fun String.logError() = Logger.e(this)
fun String.logDebug() = Logger.d(this)
fun String.logWarnign() = Logger.w(this)
fun String.logInfo() = Logger.i(this)
fun String.logVerbose() = Logger.v(this)

/* 三方依赖Logger */
fun Any?.logger(level :  Int = Logger.INFO){
    if (this == null) throw RuntimeException("The loogger value is null.")
    val type = this::class.java.simpleName
    when(level) {
        Logger.ERROR -> Logger.e("$type : $this")
        Logger.DEBUG -> Logger.d("$type : $this")
        Logger.WARN -> Logger.w("$type : $this")
        Logger.INFO -> Logger.i("$type : $this")
        Logger.VERBOSE -> Logger.v("$type : $this")
    }
}

/* Android内置Log */
fun Any?.log(level :  Int = Logger.INFO,tag: String = "PRETTY_LOGGER") {
    if (this == null) throw RuntimeException("The loogger value is null.")
    val type = this::class.java.simpleName
    when(level) {
        Logger.ERROR -> Log.e(tag,"$type : $this")
        Logger.DEBUG -> Log.d(tag,"$type : $this")
        Logger.WARN -> Log.w(tag,"$type : $this")
        Logger.INFO -> Log.i(tag,"$type : $this")
        Logger.VERBOSE -> Log.v(tag,"$type : $this")
    }
}

private var mToast: Toast? = null
private var mToastHide: Boolean = false

/* String Toast */
fun String.toast(isShort: Boolean = true) {
    if (mToastHide) return
    mToast?.cancel()
    mToast = Toast.makeText(appContext, this, if (isShort) Toast.LENGTH_SHORT else Toast.LENGTH_LONG)
    mToast?.show()
}

/* CharSequence Toast */
fun CharSequence.toast(isShort: Boolean = true) {
    if (mToastHide) return
    mToast?.cancel()
    mToast = Toast.makeText(appContext, this, if (isShort) Toast.LENGTH_SHORT else Toast.LENGTH_LONG)
    mToast?.show()
}

/* SnackBar Show 字符串参数 */
fun View.showSnackBar(text: String, actionText: String? = null, duration: Int = Snackbar.LENGTH_SHORT, actionBlock: ((snackBar: Snackbar) -> Unit)? = null) {
    val snackBar = Snackbar.make(this, text, duration)
    if (actionText != null && actionBlock != null) snackBar.setAction(actionText) { actionBlock(snackBar) }
    snackBar.show()
}

/* SnackBar Show 资源ID参数 */
fun View.showSnackBar(resId: Int, actionResId: Int? = null, duration: Int = Snackbar.LENGTH_SHORT, actionBlock: ((snackbar: Snackbar) -> Unit)? = null) {
    val snackBar = Snackbar.make(this, resId, duration)
    if (actionResId != null && actionBlock != null) snackBar.setAction(actionResId) { actionBlock(snackBar) }
    snackBar.show()
}
