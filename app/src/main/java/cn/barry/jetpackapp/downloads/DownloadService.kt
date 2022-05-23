package cn.barry.jetpackapp.downloads

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import com.barry.base.services.BaseService

class DownloadBinder : Binder()
class DownloadService : BaseService<DownloadBinder>() {
    override fun getBinder(): DownloadBinder {
        return DownloadBinder()
    }
}