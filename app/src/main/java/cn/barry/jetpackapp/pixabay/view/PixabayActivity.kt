package cn.barry.jetpackapp.pixabay.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import cn.barry.base.activity.BaseVBActivity
import cn.barry.jetpackapp.databinding.ActivityPixabayBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

/*************************
 * @Machine: RedmiBook Pro 15
 * @RelativePath: cn\barry\jetpackapp\pixabay\view\PixabayActivity.kt
 * @Path: D:\Barry\B_study\Android\Android_Project\JetpackApp\app\src\main\java\cn\barry\jetpackapp\pixabay\view\PixabayActivity.kt
 * @Author: Barry
 * @Time: 2022/5/6 13:09 周五 下午
 * @Description: PixabayActivity
 * @formatter:off
 *************************/

class PixabayActivity : BaseVBActivity<ActivityPixabayBinding, PixabayViewModel>() {

    init { isNeedLazy = true }

    override fun getViewBinding() = ActivityPixabayBinding.inflate(layoutInflater)
    override fun getViewModel(): Lazy<PixabayViewModel> = viewModel()
    override fun lazyData(){
        mViewModel.pixabayImageInfo.value ?: mViewModel.fetchImage()
    }

    @SuppressLint("Range")
    override fun init(savedInstanceState: Bundle?) {
        val pixabayAdapter = PixabayAdapter()
        mBinding.pixabayImageRecyclerView.apply {
            adapter = pixabayAdapter
            layoutManager = GridLayoutManager(this@PixabayActivity,2)
        }
        mViewModel.pixabayImageInfo.observe(this) {
            pixabayAdapter.submitList(it.dataArray)
        }
        mBinding.pixabaySwipeRefreshLayout.setOnRefreshListener {
            mViewModel.fetchImage()
            mBinding.pixabaySwipeRefreshLayout.isRefreshing = false
        }
    }

    /*fun con() {
        val url = "https://pixabay.com/get/g625cb8bed1af6ecc220fc5212a35e7e648020c3e3e3b215a58b3d94210a64208549441a450a8965ec53f5bd25cf32d11b9e5dc48ff597014de83e7d2160cc919_640.jpg"
        val cache = LruCache<String, Bitmap>(50) // least recently used
        val imageLoader = ImageLoader(queue, object : ImageLoader.ImageCache {
            override fun getBitmap(url: String?): Bitmap {
                return cache.get(url)
            }

            override fun putBitmap(url: String?, bitmap: Bitmap?) {
                cache.put(url, bitmap)
            }
        })
        imageLoader.get(url, object : ImageLoader.ImageListener {
            override fun onErrorResponse(error: VolleyError?) {
                error.logger()
            }

            override fun onResponse(response: ImageLoader.ImageContainer?, isImmediate: Boolean) {
                mBinding.pixabayImageView.setImageBitmap(response?.bitmap)
            }
        })
    }*/
}
