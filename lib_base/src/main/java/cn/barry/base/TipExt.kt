package cn.barry.base

import android.widget.Toast


/*Toast全局工具类*/
private var mToast: Toast? = null
private var mHide: Boolean = false

fun String.toast(isShort: Boolean = true) {
    if (mHide) return
    mToast?.cancel()
    mToast = Toast.makeText(appContext, this, if (isShort) Toast.LENGTH_SHORT else Toast.LENGTH_LONG)
    mToast?.show()
}

fun CharSequence.toast(isShort: Boolean = true) {
    if (mHide) return
    mToast?.cancel()
    mToast = Toast.makeText(appContext, this, if (isShort) Toast.LENGTH_SHORT else Toast.LENGTH_LONG)
    mToast?.show()
}