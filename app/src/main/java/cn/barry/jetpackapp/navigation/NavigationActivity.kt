package cn.barry.jetpackapp.navigation

import MineBBS.BaseUtil.MINEBBS_RETROFIT
import android.os.Bundle
import androidx.activity.viewModels
import cn.barry.base.activity.BaseVBActivity
import cn.barry.jetpackapp.databinding.ActivityNavigationBinding
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

class NavigationActivity : BaseVBActivity<ActivityNavigationBinding, NavigationViewModel>() {

    override fun getViewBinding() = ActivityNavigationBinding.inflate(layoutInflater)
    override fun getViewModel(): Lazy<NavigationViewModel> = viewModels()
    override fun init(savedInstanceState: Bundle?) {

        mBinding.navRefreshLayout.setOnRefreshListener {

            /*thread {
                runBlocking {
                    flow {
                        val request =
                            MINEBBS_RETROFIT.create(RequestURL::class.java).getBaseEntity().await()
                        emit(request)
                    }.onCompletion {
                        runOnUiThread {
                            mBinding.navRefreshLayout.isRefreshing = false
                        }
                    }.collect {
                        with(it) {
                            runOnUiThread {
                                mBinding.navTextView.text = StringBuilder(
                                    "data : $data \n" +
                                            "ApiCodeName : $ApiCodeName \n" +
                                            "isSuccess : $isSuccess \n" +
                                            "message : $message \n" +
                                            "ApiVersion : $ApiVersion \n" +
                                            "ApiCodeName : $ApiCodeName \n" +
                                            "currentTime : $currentTime \n" +
                                            "codeStatus : $codeStatus \n"
                                ).toString()
                            }
                        }
                    }
                }

            }*/
        }
    }

}