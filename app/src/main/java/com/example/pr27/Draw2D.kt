package com.example.pr27

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.media.Image
import android.view.View

class Draw2D(context: Context?) : View(context) {

    private val paint: Paint = Paint()
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

        paint.apply {
            style = Paint.Style.FILL
            color = backgroundPaint.color
        }

        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paint)

        // Тело кота
        paint.color = Color.WHITE
        canvas.drawCircle(offsetX, offsetY, 100 * dpiScaleFactor, paint)

        // Голова
        canvas.drawCircle(offsetX, offsetY - 150 * dpiScaleFactor, 80 * dpiScaleFactor, paint)

        // Глаза
        paint.color = Color.BLACK
        canvas.drawCircle(offsetX - 30 * dpiScaleFactor, offsetY - 170 * dpiScaleFactor, 8 * dpiScaleFactor, paint)
        canvas.drawCircle(offsetX + 30 * dpiScaleFactor, offsetY - 170 * dpiScaleFactor, 8 * dpiScaleFactor, paint)

        // Нос
        paint.color = Color.BLACK
        canvas.drawCircle(offsetX, offsetY - 150 * dpiScaleFactor, 5 * dpiScaleFactor, paint)

        // Рот
        paint.color = Color.RED
        paint.strokeWidth = 5 * dpiScaleFactor
        canvas.drawLine(offsetX - 10 * dpiScaleFactor, offsetY - 140 * dpiScaleFactor, offsetX + 10 * dpiScaleFactor, offsetY - 140 * dpiScaleFactor, paint)

        // шапка
        val path = android.graphics.Path()
        path.moveTo(offsetX - 40 * dpiScaleFactor, offsetY - 220 * dpiScaleFactor)
        path.lineTo(offsetX, offsetY - 280 * dpiScaleFactor)
        path.lineTo(offsetX + 40 * dpiScaleFactor, offsetY - 220 * dpiScaleFactor)
        canvas.drawPath(path, paint)


        // Надпись
        val textPaint = Paint().apply {
            color = Color.BLACK
            textSize = 24 * dpiScaleFactor
            typeface = Typeface.DEFAULT_BOLD
            textAlign = Paint.Align.CENTER
        }
        canvas.drawText("СНЕГОВИК", offsetX, offsetY + 150 * dpiScaleFactor, textPaint)

        //повернутый текст
        canvas.rotate(/* degrees = */ 90F, /* px = */ offsetX, /* py = */ offsetY + 150 * dpiScaleFactor,)
        canvas.drawText("СНЕГОВИК", offsetX, offsetY + 160 * dpiScaleFactor, textPaint)
    }
}
