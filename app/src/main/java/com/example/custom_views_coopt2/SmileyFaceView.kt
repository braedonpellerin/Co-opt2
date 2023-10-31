package com.example.custom_views_coopt2

//import android.content.Context
//import android.graphics.Canvas
//import android.graphics.Color
//import android.graphics.Paint
//import android.util.AttributeSet
//import android.view.View
//
//class SmileyFaceView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
//
//    private val paint = Paint().apply {
//        // Set paint properties
//        color = Color.YELLOW
//        style = Paint.Style.FILL
//    }
//
//    override fun onDraw(canvas: Canvas) {
//        super.onDraw(canvas)
//
//        // Draw a yellow circle (face)
//        canvas.drawCircle(width.toFloat() / 2, height.toFloat() / 2, 200f, paint)
//
//        // Set paint properties for eyes and mouth
//        paint.color = Color.BLACK
//        paint.style = Paint.Style.STROKE
//        paint.strokeWidth = 10f
//
//        // Draw eyes
//        canvas.drawCircle(width.toFloat() / 2 - 50, height.toFloat() / 2 - 50, 30f, paint)
//        canvas.drawCircle(width.toFloat() / 2 + 50, height.toFloat() / 2 - 50, 30f, paint)
//
//        // Draw a smiling mouth
//        canvas.drawArc(
//            width.toFloat() / 2 - 60, height.toFloat() / 2 - 40,
//            width.toFloat() / 2 + 60, height.toFloat() / 2 + 60,
//            0f, 180f, false, paint
//        )
//    }
//}

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator

class SmileyFaceView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private val paint = Paint()
    private var mouthAngle = 0f

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Set paint properties
        paint.color = Color.YELLOW
        paint.style = Paint.Style.FILL

        // Draw a yellow circle (face)
        canvas.drawCircle(width.toFloat() / 2, height.toFloat() / 2, 200f, paint)

        // Set paint properties for eyes and mouth
        paint.color = Color.BLACK
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 10f

        // Draw eyes
        canvas.drawCircle(width.toFloat() / 2 - 50, height.toFloat() / 2 - 50, 30f, paint)
        canvas.drawCircle(width.toFloat() / 2 + 50, height.toFloat() / 2 - 50, 30f, paint)

        // Draw a smiling mouth based on the animated mouth angle
        val startAngle = 180f - mouthAngle / 2
        val sweepAngle = 180f + mouthAngle
        canvas.drawArc(
            width.toFloat() / 2 - 60, height.toFloat() / 2 - 40,
            width.toFloat() / 2 + 60, height.toFloat() / 2 + 60,
            startAngle, sweepAngle, false, paint
        )
    }

    fun startSmileAnimation() {
        val animator = ValueAnimator.ofFloat(0f, 180f)
        animator.duration = 2000 // You can adjust the duration as needed
        animator.interpolator = LinearInterpolator()
        animator.repeatCount = ValueAnimator.INFINITE
        animator.repeatMode = ValueAnimator.REVERSE
        animator.addUpdateListener { animation ->
            mouthAngle = animation.animatedValue as Float
            invalidate()
        }
        animator.start()
    }
}