package com.example.jucrchallenge.utils

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.jucrchallenge.R
import com.example.jucrchallenge.databinding.CustomCircularProgressViewBinding

class CircularProgressView(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {
    private val binding: CustomCircularProgressViewBinding = CustomCircularProgressViewBinding.inflate(
        LayoutInflater.from(context),
        this, true
    )
    private val ta = context.obtainStyledAttributes(attrs, R.styleable.CircularProgressView)
    private var progressValue = ta.getFloat(R.styleable.CircularProgressView_progress, 50f)
        set(value) = setProgress(value)
    private var imageRes = ta.getInteger(R.styleable.CircularProgressView_image, R.drawable.baseline_power_24)
        set(value) = setImage(ContextCompat.getDrawable(context, value))

    init {
        setProgress(progressValue)
        setImage(ContextCompat.getDrawable(context, imageRes))
        ta.recycle()
    }

    @SuppressLint("SetTextI18n")
    fun setProgress(progress: Float) {
        binding.progressBar.progress = progress.toInt()
        binding.progressTv.text = "${progress.toInt()}%"
        invalidate()
    }

    fun setImage(drawable: Drawable?) {
        binding.progressIcon.setImageDrawable(drawable)
        invalidate()
    }

}
