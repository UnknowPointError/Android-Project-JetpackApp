package cn.barry.base.view

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat

/*************************
 * @Machine: RedmiBook Pro 15 Win11
 * @Path: lib_base/src/main/java/cn/barry/base/view
 * @Time: 2022/5/16 21:37
 * @Author: BarryAllen
 * @Description: StatusBarExt
 * @formatter:off
 **************************/

fun Activity.setTransparentStatusBar() = StatusBarUtil.setTransparentStatusBar(this)

fun Activity.setStatusBarStyle(isDark: Boolean = true) = StatusBarUtil.setStatusBarStyle(this, isDark)

fun View.setFitSystemWindow() {
    layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
    fitsSystemWindows = true
}

object StatusBarUtil {
    fun setTransparentStatusBar(activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
            activity.window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            val opt =
                activity.window.decorView.systemUiVisibility or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            activity.window.decorView.systemUiVisibility = opt
        } else {
            activity.window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        activity.window.navigationBarColor = Color.TRANSPARENT
        activity.window.statusBarColor = Color.TRANSPARENT
    }

    fun setStatusBarColor(activity: AppCompatActivity, @ColorRes colorRes: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            activity.window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            activity.window.statusBarColor = activity.resources.getColor(colorRes)
        }
    }

    fun setStatusBarStyle(activity: Activity, isDark: Boolean) {
        setAndroidDefaultStatusBarStyle(activity, isDark)
    }

    private fun setAndroidDefaultStatusBarStyle(activity: Activity, isDark: Boolean) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            activity.window.decorView.apply {
                systemUiVisibility = if (isDark) {
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                } else {
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                }
            }
        }
    }

    fun getStatusBarHeight(ctx: Context): Int {
        val resourceId = ctx.resources.getIdentifier("status_bar_height", "dimen", "android")
        return if (resourceId > 0) {
            ctx.resources.getDimensionPixelSize(resourceId)
        } else {
            0
        }
    }
}

context(Activity)
fun setStatusBarIsDark(isDark: Boolean) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        ViewCompat.getWindowInsetsController(window.decorView)?.isAppearanceLightStatusBars = true
        window.insetsController?.setSystemBarsAppearance(WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS, WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS);
        window.statusBarColor = Color.TRANSPARENT
    } else {
        window.decorView.apply {
            systemUiVisibility = if (isDark) View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            else View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        }
    }
}