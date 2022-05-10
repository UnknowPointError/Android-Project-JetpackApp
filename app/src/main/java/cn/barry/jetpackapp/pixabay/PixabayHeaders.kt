package cn.barry.jetpackapp.pixabay

import cn.barry.jetpackapp.pixabay.model.ModelEntity
import kotlinx.coroutines.flow.Flow

/*************************
 * @Machine: RedmiBook Pro 15 Win11
 * @Path: app/src/main/java/cn/barry/jetpackapp/pixabay
 * @Time: 2022/5/6 15:47
 * @Author: BarryAllen
 * @Description: PixabayHeaders
 **************************/

typealias PixabayEntity_Flow = Flow<ModelEntity.GET.PixabayEntity>
typealias PixabayEntity = ModelEntity.GET.PixabayEntity
typealias PixabayEntity_Child_Image = ModelEntity.GET.PixabayEntity.PixabayImageEntity