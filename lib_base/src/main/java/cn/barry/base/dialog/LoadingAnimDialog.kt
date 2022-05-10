package cn.barry.base.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.FragmentManager
import cn.barry.base.databinding.BaseDialogLoadingBinding

/*************************
 * @Machine: RedmiBook Pro 15
 * @RelativePath: cn\barry\base\dialog\LoadingAnimDialog.kt
 * @Path: D:\Barry\B_study\Android\Android_Project\JetpackApp\lib_base\src\main\java\cn\barry\base\dialog\LoadingAnimDialog.kt
 * @Author: Barry
 * @Time: 2022/5/2 12:23 周一 下午
 * @Description: 加载动画弹窗
 * @formatter:off
 *************************/

class LoadingAnimDialog : BaseVBDialogFragment<BaseDialogLoadingBinding>() {

    companion object {
        fun show(fragmentManager: FragmentManager) {
            val dialog = fragmentManager.findFragmentByTag(DIALOG_TAG) as? LoadingAnimDialog ?: LoadingAnimDialog()
            if (!dialog.isVisible) dialog.show(fragmentManager, DIALOG_TAG)
        }

        fun dismiss(fragmentManager: FragmentManager) {
            val dialog = fragmentManager.findFragmentByTag(DIALOG_TAG) as? LoadingAnimDialog
            if (dialog?.isVisible == true) dialog.dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        setIsCancelable(false)
        setMaskAmount(0f)
        setBackgroundTransparent()
    }

    override fun getViewBind(layoutInflater: LayoutInflater): BaseDialogLoadingBinding {
        return BaseDialogLoadingBinding.inflate(layoutInflater)
    }
}