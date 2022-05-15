package cn.barry.base.dialog

import android.app.AlertDialog
import android.content.Context

/*************************
 * @Machine: RedmiBook Pro 15 Win11
 * @Path: lib_base/src/main/java/cn/barry/base/dialog
 * @Time: 2022/5/11 21:38
 * @Author: BarryAllen
 * @Description: Dialog
 **************************/

inline fun Context.createDialog(
    dialogConfig: AlertDialog.Builder.() -> Unit
) {
    AlertDialog.Builder(this).apply {
        dialogConfig()
        create()
        show()
    }
}