package com.balanza.android.hploading

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.animation.LinearInterpolator


/**
 * Created by balanza on 21/02/17.
 */
class HPLoading : View, ValueAnimator.AnimatorUpdateListener {

  //  Attributes
  var color = 0
  var strokewidth = 0f
  var period = 0

  val paint = Paint()
  val valueAnimator = ValueAnimator()
  val trianglePath = Path()

  var point1 = PointF()
  var point2 = PointF()
  var point3 = PointF()
  var pointCenterBase = PointF()

  var rect = RectF()

  var radiusCircle = 0f

  var circleWidthValue = 0f

  constructor(context: Context) : super(context) {
    init()
  }

  constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
    setAttributes(context, attrs)
    init()
  }

  constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs,
      defStyleAttr) {
    setAttributes(context, attrs)
    init()
  }

  override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec)

    val width = MeasureSpec.getSize(widthMeasureSpec)
    val height = MeasureSpec.getSize(heightMeasureSpec)

    setMeasuredDimension(width, height)
  }

  override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
    super.onSizeChanged(w, h, oldw, oldh)
    createPoints()
    createTrianglePath()
    createRectangle()
    start()
  }

  private fun setAttributes(context: Context, attrs: AttributeSet) {
    val a = context.theme.obtainStyledAttributes(attrs, R.styleable.HPLoading, 0, 0)
    try {
      color = a.getColor(R.styleable.HPLoading_color, Color.BLACK)
      strokewidth = a.getDimension(R.styleable.HPLoading_stroke_width, 10f)
      period = a.getInt(R.styleable.HPLoading_period, 1000)
    } finally {
      a.recycle()
    }
  }

  override fun onDraw(canvas: Canvas) {
    //draw triangle
    canvas.drawPath(trianglePath, paint)

    //draw line
    canvas.drawLine(point1.x, point1.y, pointCenterBase.x, pointCenterBase.y, paint)

    //draw circle
    rect.left = (point1.x - (radiusCircle * circleWidthValue))
    rect.right = (point1.x + (radiusCircle * circleWidthValue))
    canvas.drawOval(rect, paint)
  }

  fun start() {
    valueAnimator.start()
  }

  override fun onAnimationUpdate(valueAnimator: ValueAnimator) {
    circleWidthValue = valueAnimator.animatedFraction
    invalidate()
  }

  private fun init() {
    initPaint()
    initValueAnimator()
  }

  private fun initPaint() {
    paint.color = color
    paint.style = Paint.Style.STROKE
    paint.strokeWidth = strokewidth
    paint.isAntiAlias = true
  }

  private fun initValueAnimator() {
    valueAnimator.duration = period.toLong() / 2
    valueAnimator.setFloatValues(0f, 1f)
    valueAnimator.addUpdateListener(this)
    valueAnimator.repeatMode = ValueAnimator.REVERSE
    valueAnimator.repeatCount = ValueAnimator.INFINITE
    valueAnimator.interpolator = LinearInterpolator()
  }

  private fun createPoints() {
    val viewHeight = height.toFloat() - paint.strokeWidth

    val side = (2 * viewHeight) / (Math.sqrt(3.0))

    val finalSide: Float

    val triangleHeight: Float


    if (side > width) {
      finalSide = width.toFloat() - paint.strokeWidth * 2
      triangleHeight = ((finalSide * Math.sqrt(3.0)) / 2).toFloat()
    } else {
      finalSide = side.toFloat()
      triangleHeight = viewHeight - paint.strokeWidth
    }

    val middleA = finalSide / 2f

    val centralPoint = PointF(width / 2f, height / 2f)

    point1.x = centralPoint.x
    point1.y = centralPoint.y - triangleHeight / 2

    point2.x = point1.x + middleA
    point2.y = point1.y + triangleHeight

    point3.x = point1.x - middleA.toInt()
    point3.y = point1.y + triangleHeight

    pointCenterBase = PointF(point1.x, point1.y + triangleHeight)

    radiusCircle = (Math.sqrt(3.0).toFloat() / 6f) * finalSide - (paint.strokeWidth)
  }

  private fun createTrianglePath() {
    trianglePath.moveTo(point1.x, point1.y)
    trianglePath.lineTo(point2.x, point2.y)
    trianglePath.lineTo(point3.x, point3.y)
    trianglePath.close()
  }

  private fun createRectangle() {
    rect = RectF(point1.x - radiusCircle,
        pointCenterBase.y - (2f * radiusCircle) - paint.strokeWidth,
        point1.x + radiusCircle,
        pointCenterBase.y - paint.strokeWidth)
  }

}