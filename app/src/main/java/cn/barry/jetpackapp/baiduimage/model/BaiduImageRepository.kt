package cn.barry.jetpackapp.baiduimage.model

import cn.barry.jetpackapp.baiduimage.BaiduImageAccessTokenEntity_Flow
import cn.barry.jetpackapp.baiduimage.network.BaiduImageService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn

class BaiduImageRepository(val modelService: BaiduImageService) {

    fun getAccessToken(): BaiduImageAccessTokenEntity_Flow = modelService.getAccessToken().flowOn(Dispatchers.IO)
}