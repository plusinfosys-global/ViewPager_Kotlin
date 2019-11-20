package com.plusinfosys.viewpager.horizontal

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View


class MyVerticalViewPager : ViewPager {
    constructor(context: Context) : super(context) {
        bounceffect()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        bounceffect()
    }

    fun bounceffect() {
        setPageTransformer(true, ViewPagerTransformer())
        setOverScrollMode(View.OVER_SCROLL_NEVER)
    }

    private fun SwipeXY(motionEvent: MotionEvent): MotionEvent {
        val x = getWidth().toFloat()
        val y = getHeight().toFloat()

        val NewX = motionEvent.y / y * y
        val NewY = motionEvent.x / x * x

        motionEvent.setLocation(NewX, NewY)

        return motionEvent
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        val intercept = super.onInterceptTouchEvent(SwipeXY(ev))

        SwipeXY(ev)

        return intercept

    }

    override fun onTouchEvent(ev: MotionEvent): Boolean {
        return super.onTouchEvent(SwipeXY(ev))

    }

    inner class ViewPagerTransformer : ViewPager.PageTransformer {
        private val M_SCALE = 0.65f

        override fun transformPage(page: View, position: Float) {
            if (position < -1) {
                page.alpha = 0f
            } else if (position <= 0) {
                page.alpha = 1f
                page.translationX = page.width * -position
                page.translationY = page.height * position
                page.scaleX = 1f
                page.scaleY = 1f
            } else if (position <= 1) {
                page.alpha = 1 - position
                page.translationX = page.width * -position
                page.translationY = 0f
                val scal_facter = M_SCALE + (1 - M_SCALE) * (1 - Math.abs(position))
                page.scaleX = scal_facter
                page.scaleY = scal_facter
            } else if (position > 1) {
                page.alpha = 0f
            }
        }
    }
}