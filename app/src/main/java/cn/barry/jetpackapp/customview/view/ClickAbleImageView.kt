package cn.barry.jetpackapp.customview.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.SurfaceView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.res.ResourcesCompat
import cn.barry.jetpackapp.R

/*************************
 * @Machine: RedmiBook Pro 15 Win11
 * @Path: app/src/main/java/cn/barry/jetpackapp/customview/view
 * @Time: 2022/5/9 10:01
 * @Author: BarryAllen
 * @Description: ClickableImageView
 * @formatter:off
 **************************/
class ClickAbleImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    private val drawableList: ArrayList<Drawable> = arrayListOf()
    var beforeDrawable: Drawable? = null
    var afterDrawable: Drawable? = null

    init {
        context.theme.obtainStyledAttributes(attrs, R.styleable.ClickAbleImageView, 0, 0).apply {
            foreground = null
            try {
                afterDrawable = getDrawable(R.styleable.ClickAbleImageView_afterClickSrc)
                beforeDrawable = getDrawable(R.styleable.ClickAbleImageView_beforeClickSrc)
            } finally {
                beforeDrawable?.let { drawable ->
                    background = beforeDrawable
                }
                recycle()
            }
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                background = afterDrawable
            }
            MotionEvent.ACTION_UP -> {
                background = beforeDrawable
            }
        }
        return true
    }
}