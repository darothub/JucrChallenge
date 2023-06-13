package com.example.jucrchallenge.model

import androidx.annotation.DrawableRes
import com.example.jucrchallenge.R

data class StatisticsModel(
    @DrawableRes val icon: Int,
    val measurement: String,
    val remark: String
) {
    companion object {
        var sampleList = arrayListOf<StatisticsModel>(
            StatisticsModel(R.drawable.baseline_power_24, "200 Volts", "Voltage"),
            StatisticsModel(R.drawable.baseline_power_24, "200 Km", "Charging"),
            StatisticsModel(R.drawable.baseline_power_24, "200 Mile", "Voltage"),
            StatisticsModel(R.drawable.baseline_power_24, "200 Km", "Remark"),
            StatisticsModel(R.drawable.baseline_power_24, "200 Mile", "Charged")
        )
    }
}