package cn.barry.jetpackapp.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import cn.barry.base.showSnackBar
import cn.barry.base.toast
import cn.barry.jetpackapp.databinding.ActivityLivedataBinding
import com.google.android.material.snackbar.Snackbar
import org.koin.android.ext.android.inject

class LiveDataActivity : AppCompatActivity() {

    private val mBinding by lazy { ActivityLivedataBinding.inflate(layoutInflater) }
    private val viewModel : LiveDataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        with(mBinding) {
            livedataFloatingButton.setOnClickListener {
                it.showSnackBar("Data Deleted." ,"Undo") {
                    "Data Restored.".toast()
                }
            }

            livedataAddNum.setOnClickListener {
                viewModel.addNum()
                viewModel.number.value?.toString()?.toast()
            }

            livedataClearNum.setOnClickListener {
                viewModel.clearNum()
            }

            viewModel.number.observe(this@LiveDataActivity) {

                livedataTextView.text = viewModel.number.value.toString()
            }
        }
    }
}