package cn.barry.base

import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar


/*Toast全局工具类*/
private var mToast: Toast? = null
private var mHide: Boolean = false

fun String.toast(isShort: Boolean = true) {
    if (mHide) return
    mToast?.cancel()
    mToast =
        Toast.makeText(appContext, this, if (isShort) Toast.LENGTH_SHORT else Toast.LENGTH_LONG)
    mToast?.show()
}

fun CharSequence.toast(isShort: Boolean = true) {
    if (mHide) return
    mToast?.cancel()
    mToast =
        Toast.makeText(appContext, this, if (isShort) Toast.LENGTH_SHORT else Toast.LENGTH_LONG)
    mToast?.show()
}
fun View.showSnackBar(
    text: String,
    actionText: String? = null,
    duration: Int = Snackbar.LENGTH_SHORT,
    block: (() -> Unit)? = null
) {
    val snackbar = Snackbar.make(this, text, duration)
    if (actionText != null && block != null) {
        snackbar.setAction(actionText) { block() }
    }
    snackbar.show()
}

fun View.showSnackBar(
    resId: Int,
    actionResId: Int? = null,
    duration: Int = Snackbar.LENGTH_SHORT,
    block: (() -> Unit)? = null
) {
    val snackbar = Snackbar.make(this, resId, duration)
    if (actionResId != null && block != null) {
        snackbar.setAction(actionResId) { block() }
    }
    snackbar.show()
}
