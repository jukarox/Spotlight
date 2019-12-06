package com.takusemba.spotlight.effet

import android.animation.ObjectAnimator
import android.animation.TimeInterpolator
import android.animation.ValueAnimator
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PointF
import android.view.animation.DecelerateInterpolator
import androidx.annotation.ColorInt
import java.util.concurrent.TimeUnit

/**
 * Draws an ripple effects.
 */
class PulseEffect(
    private val offset: Float,
    private val radius: Float,
    @ColorInt private val color: Int,
    override val duration: Long = DEFAULT_DURATION,
    override val interpolator: TimeInterpolator = DEFAULT_INTERPOLATOR,
    override val repeatMode: Int = DEFAULT_REPEAT_MODE,
    override val repeatCount: Int = DEFAULT_REPEAT_COUNT,
    override val anchor: PointF? = null
) : Effect {

  override fun draw(canvas: Canvas, point: PointF, value: Float, paint: Paint) {
    paint.color = color
    paint.alpha = (255 * (value * -1)).toInt()

    val calculatedRadius = (radius) * value

    val extraRadius = radius / 2

    canvas.drawCircle(point.x, point.y, calculatedRadius + offset, paint)

    canvas.drawCircle(point.x, point.y, calculatedRadius + offset + extraRadius, paint)

    canvas.drawCircle(point.x, point.y, calculatedRadius + offset + (extraRadius * 2), paint)
  }

  companion object {

    val DEFAULT_DURATION = TimeUnit.MILLISECONDS.toMillis(1000)

    val DEFAULT_INTERPOLATOR = DecelerateInterpolator(1f)

    const val DEFAULT_REPEAT_MODE = ObjectAnimator.RESTART

    const val DEFAULT_REPEAT_COUNT = ValueAnimator.INFINITE
  }
}