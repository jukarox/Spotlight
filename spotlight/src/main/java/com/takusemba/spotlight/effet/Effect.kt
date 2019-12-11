package com.takusemba.spotlight.effet

import android.animation.TimeInterpolator
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PointF

/**
 * Additional effect drawing in loop to Shape.
 */
interface Effect {

  /**
   * [duration] to draw Effect.
   */
  val duration: Long

  /**
   * [interpolator] to draw Effect.
   */
  val interpolator: TimeInterpolator

  /**
   * [repeatMode] to draw Effect.
   */
  val repeatMode: Int

  /**
   * [repeatCount] to draw Effect.
   */
  val repeatCount: Int

  /**
   * [anchor] to draw Effect.
   */
  val anchor: PointF?

  /**
   * [startDelay] to draw Effect.
   */
  val startDelay: Long

  /**
   * Draw the Effect.
   *
   * @param value the animated value from 0 to 1 and this value is looped until Target finishes.
   */
  fun draw(canvas: Canvas, point: PointF, value: Float, paint: Paint)
}