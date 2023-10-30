package com.example.custom_views_coopt2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class SmileyFaceView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint().apply {
        // Set paint properties
        color = Color.YELLOW
        style = Paint.Style.FILL
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Draw a yellow circle (face)
        canvas.drawCircle(width.toFloat() / 2, height.toFloat() / 2, 200f, paint)

        // Set paint properties for eyes and mouth
        paint.color = Color.BLACK
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 10f

        // Draw eyes
        canvas.drawCircle(width.toFloat() / 2 - 50, height.toFloat() / 2 - 50, 30f, paint)
        canvas.drawCircle(width.toFloat() / 2 + 50, height.toFloat() / 2 - 50, 30f, paint)

        // Draw a smiling mouth
        canvas.drawArc(
            width.toFloat() / 2 - 60, height.toFloat() / 2 - 40,
            width.toFloat() / 2 + 60, height.toFloat() / 2 + 60,
            0f, 180f, false, paint
        )
    }
}
