package cn.barry.jetpackapp.pixabay.model

import cn.barry.base.network.volleyRequest
import cn.barry.jetpackapp.pixabay.PixabayEntity
import cn.barry.jetpackapp.pixabay.PixabayEntity_Flow
import com.android.volley.RequestQueue

object PixabayRepository {

    fun getImage(queue: RequestQueue): PixabayEntity_Flow {
        val url = "https://pixabay.com/api/?key=27218894-ae7cc4f2d59abbd6bddb4eb8c&q=girl&per_page=100"
        return volleyRequest<PixabayEntity>(queue,url)
    }
}