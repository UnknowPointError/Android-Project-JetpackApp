@file:Suppress("DEPRECATION")

package com.barry.base.view

import android.app.Activity
import android.os.Build
import android.view.View
import androidx.core.view.ViewCompat

/*************************
 * @Machine: RedmiBook Pro 15 Win11
 * @Path: lib_base/src/main/java/cn/barry/base/view
 * @Time: 2022/5/16 21:37
 * @Author: BarryAllen
 * @Description: StatusBarExt
 * @formatter:off
 **************************/

/* 设置状态栏文字图标是否暗色 */
context(Activity) fun setStatusBarIsDark(isDark: Boolean = true) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        ViewCompat.getWindowInsetsController(window.decorView)?.isAppearanceLightStatusBars = isDark
    } else {
        window.decorView.systemUiVisibility = if (isDark) View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR else View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    }
}