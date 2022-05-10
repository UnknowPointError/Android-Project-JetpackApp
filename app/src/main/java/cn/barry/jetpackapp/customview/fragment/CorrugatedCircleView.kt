package cn.barry.jetpackapp.customview.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.DiscretePathEffect
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.Window
import androidx.core.view.isGone
import androidx.core.view.isVisible
import cn.barry.base.coroutine.defaultCoroutine
import cn.barry.base.extensions.log
import cn.barry.base.extensions.logger
import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.coroutines.coroutineContext

/*************************
 * @Machine: RedmiBook Pro 15 Win11
 * @Path: app/src/main/java/cn/barry/jetpackapp/customview/fragment
 * @Time: 2022/5/8 12:54
 * @Author: BarryAllen
 * @Description: CorrugatedCircleView
 **************************/
class CorrugatedCircleView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : SurfaceView(context, attrs, defStyleAttr) {

    private var job : Job? = null
    private val color = arrayOf(
        Color.BLUE,
        Color.BLACK,
        Color.GRAY,
        Color.YELLOW,
        Color.GREEN,
        Color.RED,
        Color.MAGENTA,
        Color.DKGRAY
    )
    private val paint = Paint().apply {
        style = Paint.Style.STROKE
        strokeWidth = 5f
        pathEffect = DiscretePathEffect(30f, 20f)
    }
    private val bubbleList: MutableList<Bubble> = mutableListOf()

    data class Bubble(val x: Float, val y: Float, val color: Int, var radius: Float)


    init {
        defaultCoroutine.launch {
            while (true)
                if (holder.surface.isValid) {
                    val canvas = holder.lockCanvas()
                    canvas.drawColor(Color.BLACK)
                    bubbleList.toList().forEach {
                        if (it.radius >= 3000) bubbleList.remove(it)
                        paint.color = it.color
                        canvas.drawCircle(it.x, it.y, it.radius, paint)
                        it.radius += 10
                    }
                    holder.unlockCanvasAndPost(canvas)
                }
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.let { events ->
            if (events.pointerCount > 1)
                repeat(events.pointerCount) {
                    bubbleList.add(Bubble(events.getX(it), events.getY(it), color.random(), 0f))
                    if (bubbleList.size > 40) bubbleList.removeAt(0)
                }
            else {
                bubbleList.add(Bubble(events.x, events.y, color.random(), 0f))
                if (bubbleList.size > 40) bubbleList.removeAt(0)
            }
        }
        return true
    }
}