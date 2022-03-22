package cn.barry.jetpackapp.koin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cn.barry.base.toast
import cn.barry.jetpackapp.R
import org.koin.android.ext.android.inject

class KoinActivity : AppCompatActivity() {

    val app: SingleClass by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_koin)
        app.count++
        app.count.toString().toast()
    }
}