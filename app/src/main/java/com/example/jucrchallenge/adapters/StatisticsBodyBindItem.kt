package com.example.jucrchallenge.adapters

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.View
import androidx.core.content.ContextCompat
import com.example.jucrchallenge.R
import com.example.jucrchallenge.databinding.StaticsItemViewBinding
import com.example.jucrchallenge.model.StatisticsModel
import com.xwray.groupie.viewbinding.BindableItem

class StatisticsBodyBindItem(val statistics: StatisticsModel): BindableItem<StaticsItemViewBinding>() {
    override fun bind(viewBinding: StaticsItemViewBinding, position: Int) {
        val listOfColor = listOf(
            Color.CYAN,
            Color.RED,
            Color.BLUE,
            Color.GREEN
        )
        val randomNumber = (listOfColor.indices).random()
        var backgroundColor = listOfColor[randomNumber]
        val shapeDrawable =  GradientDrawable();
        shapeDrawable.shape = GradientDrawable.OVAL;
        shapeDrawable.setColor(backgroundColor);
        shapeDrawable.alpha = 100
        val context = viewBinding.icon.context
        val drawable = ContextCompat.getDrawable(context, statistics.icon)
        viewBinding.apply {
            icon.setImageDrawable(drawable)
            icon.background = shapeDrawable
            measurementTv.text = statistics.measurement
            remarkTv.text = statistics.remark
        }

    }

    override fun getLayout(): Int = R.layout.statics_item_view

    override fun initializeViewBinding(view: View): StaticsItemViewBinding = StaticsItemViewBinding.bind(view)
}