package com.example.pr27

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Typeface
import android.view.View

class Draw2D(context: Context?) : View(context) {

    private val catPaint: Paint = Paint()
    private val backgroundPaint: Paint = Paint()

    init {
        backgroundPaint.color = Color.rgb(173, 216, 230)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val dpiScaleFactor = resources.displayMetrics.density

        // Расчет смещения для центрирования
        val offsetX = width / 2F
        val offsetY = height / 2F

        // Заливка заднего фона
        canvas.drawCircle(offsetX, offsetY, Math.max(width, height) / 2F, backgroundPaint)

        // Тело кота
        catPaint.color = Color.WHITE
        canvas.drawCircle(offsetX, offsetY, 100 * dpiScaleFactor, catPaint)

        // Голова кота
        canvas.drawCircle(offsetX, offsetY - 150 * dpiScaleFactor, 80 * dpiScaleFactor, catPaint)

        // Глаза
        catPaint.color = Color.BLACK
        canvas.drawCircle(offsetX - 30 * dpiScaleFactor, offsetY - 170 * dpiScaleFactor, 8 * dpiScaleFactor, catPaint)
        canvas.drawCircle(offsetX + 30 * dpiScaleFactor, offsetY - 170 * dpiScaleFactor, 8 * dpiScaleFactor, catPaint)

        // Нос
        catPaint.color = Color.BLACK
        canvas.drawCircle(offsetX, offsetY - 150 * dpiScaleFactor, 5 * dpiScaleFactor, catPaint)

        // Рот
        catPaint.color = Color.RED
        catPaint.strokeWidth = 5 * dpiScaleFactor
        canvas.drawLine(offsetX - 10 * dpiScaleFactor, offsetY - 140 * dpiScaleFactor, offsetX + 10 * dpiScaleFactor, offsetY - 140 * dpiScaleFactor, catPaint)

        // шапка
        val path = android.graphics.Path()
        path.moveTo(offsetX - 40 * dpiScaleFactor, offsetY - 220 * dpiScaleFactor)
        path.lineTo(offsetX, offsetY - 280 * dpiScaleFactor)
        path.lineTo(offsetX + 40 * dpiScaleFactor, offsetY - 220 * dpiScaleFactor)
        canvas.drawPath(path, catPaint)



        // Надпись
        val textPaint = Paint().apply {
            color = Color.BLACK
            textSize = 24 * dpiScaleFactor
            typeface = Typeface.DEFAULT_BOLD
            textAlign = Paint.Align.CENTER
        }

        canvas.drawText("СНЕГОВИК", offsetX, offsetY + 150 * dpiScaleFactor, textPaint)
    }
}
