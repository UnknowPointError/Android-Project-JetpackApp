package cn.barry.jetpackapp.downloads

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import androidx.core.app.NotificationCompat
import cn.barry.jetpackapp.MainActivity
import cn.barry.jetpackapp.R
import cn.barry.jetpackapp.databinding.ActivityDownloadBinding
import com.barry.base.activity.BaseVBActivity
import com.barry.base.app.appContext
import org.koin.androidx.viewmodel.ext.android.viewModel

/*************************
 * @Machine: RedmiBook Pro 15
 * @RelativePath: cn\barry\jetpackapp\downloads\DownloadActivity.kt
 * @Path: D:\Barry\B_study\Android\Android_Project\JetpackApp\app\src\main\java\cn\barry\jetpackapp\downloads\DownloadActivity.kt
 * @Author: Barry
 * @Time: 2022/5/22 18:16 周日 下午
 * @Description: DownloadActivity
 * @formatter:off
*************************/

class DownloadActivity : BaseVBActivity<ActivityDownloadBinding, DownloadViewModel>() {

    companion object {
        const val TAG = "Download"
    }

    override fun getViewBinding() = ActivityDownloadBinding.inflate(layoutInflater)
    override fun getViewModel(): Lazy<DownloadViewModel> = viewModel()
    override fun doInitOnCreate(savedInstanceState: Bundle?) {
        mBinding.downloadMaterialButton.setOnClickListener {

        }
        sendNotice()
    }

    private fun sendNotice() {
        Intent(this,MainActivity::class.java).let { intent ->
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            with((getSystemService(NOTIFICATION_SERVICE) as NotificationManager)) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) createNotificationChannel(NotificationChannel(TAG,"Download",NotificationManager.IMPORTANCE_DEFAULT))
                NotificationCompat.Builder(this@DownloadActivity,TAG)
                    .setContentTitle("Title")
                    .setContentText("Text")
                    .setWhen(System.currentTimeMillis())
                    .setSmallIcon(appContext.applicationInfo.icon)
                    .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.ic_baseline_face_24))
                    .setAutoCancel(true)
                    .setContentIntent(PendingIntent.getActivity(this@DownloadActivity,0,intent,PendingIntent.FLAG_IMMUTABLE))
                    .build()
                    .also { notification ->
                        notify(0,notification)
                    }
            }
        }
    }
}
