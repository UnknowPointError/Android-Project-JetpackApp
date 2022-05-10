package cn.barry.jetpackapp.pixabay.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cn.barry.base.viewmodel.BaseViewModel
import cn.barry.jetpackapp.pixabay.PixabayEntity
import cn.barry.jetpackapp.pixabay.model.PixabayRepository
import com.android.volley.RequestQueue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn

/*************************
 * @Machine: RedmiBook Pro 15 Win11
 * @Path: app/src/main/java/cn/barry/jetpackapp/pixabay/view
 * @Time: 2022/5/6 12:41
 * @Author: BarryAllen
 * @Description: PixabayViewModel
 **************************/
class PixabayViewModel(val queue: RequestQueue) : BaseViewModel() {

    private val _pixabayImageInfo = MutableLiveData<PixabayEntity>()
    val pixabayImageInfo: LiveData<PixabayEntity> get() = _pixabayImageInfo

    fun fetchImage() {
        volleyFlowLaunch(PixabayRepository.getImage(queue).flowOn(Dispatchers.IO)) {
            _pixabayImageInfo.value = it
        }
    }
}