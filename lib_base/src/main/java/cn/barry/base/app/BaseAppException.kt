package cn.barry.base.app

import android.app.AlertDialog
import android.content.Intent
import android.os.Process
import android.os.Build
import android.view.LayoutInflater
import android.view.WindowManager
import androidx.annotation.RequiresApi
import cn.barry.base.R
import cn.barry.base.coroutine.uiLaunch
import cn.barry.base.databinding.BaseAppExceptionDialogBinding
import cn.barry.base.extensions.logger
import com.orhanobut.logger.Logger


/*************************
 * @Machine: RedmiBook Pro 15 Win11
 * @Path: lib_base/src/main/java/cn/barry/base/app
 * @Time: 2022/5/8 18:11
 * @Author: BarryAllen
 * @Description: BaseAppException
 **************************/
class BaseAppException : Thread.UncaughtExceptionHandler {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun uncaughtException(t: Thread, e: Throwable) {
        val exception = e.stackTraceToString()
        exception.logger(Logger.ERROR)
        uiLaunch {
            val binding = BaseAppExceptionDialogBinding.bind(LayoutInflater.from(appContext).inflate(R.layout.base_app_exception_dialog,null,false))
            binding.baseExceptionDialogTextView.text = exception
            val builder = AlertDialog.Builder(appContext)
            builder.setView(binding.root)
            val dialog = builder.create()
            dialog.window?.let { window ->
                dialog.setCustomTitle(LayoutInflater.from(appContext).inflate(R.layout.base_app_exception_title,null,false))
                window.setType(WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY)
                window.setDimAmount(0.5F)
                window.setBackgroundDrawableResource(R.drawable.base_dialog_circle_drawable)
                dialog.setCanceledOnTouchOutside(false)
                dialog.show()
                window.setLayout(appContext.resources.displayMetrics.widthPixels, appContext.resources.displayMetrics.heightPixels / 2)
            }
            binding.baseExceptionDialogOkButton.setOnClickListener {
                dialog.dismiss()
            }
            binding.baseExceptionDialogRestartButton.setOnClickListener {
                appContext.packageManager.getLaunchIntentForPackage(appContext.packageName)?.apply {
                    addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    appContext.startActivity(this)
                }
                Process.killProcess(Process.myPid())
            }
        }
    }
}