package com.example.jucrchallenge

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jucrchallenge.adapters.NearbySuperChargesBindItem
import com.example.jucrchallenge.adapters.NearbySuperChargesHeaderBindItem
import com.example.jucrchallenge.adapters.StatisticsBodyBindItem
import com.example.jucrchallenge.databinding.ActivityMainBinding
import com.example.jucrchallenge.model.NearBySuperchargesModel
import com.example.jucrchallenge.model.StatisticsModel
import com.example.jucrchallenge.utils.viewBinding
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.Section


class MainActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityMainBinding::inflate)
    private val groupAdapter = GroupieAdapter()
    private val groupAdapter2 = GroupieAdapter()
    private val statisticsSection = Section()
    private val statisticsBodyList = mutableListOf<StatisticsBodyBindItem>()
    private val chargesSection = Section(NearbySuperChargesHeaderBindItem())
    private val nearBySuperChargesList = mutableListOf<NearbySuperChargesBindItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        groupAdapter.add(statisticsSection)
        groupAdapter2.add(chargesSection)
        StatisticsModel.sampleList.forEach {
            val item = StatisticsBodyBindItem(it)
            statisticsBodyList.add(item)
        }
        NearBySuperchargesModel.sampleList.forEach {
            val item = NearbySuperChargesBindItem(it)
            nearBySuperChargesList.add(item)
        }

        binding.recyclerViewH.apply {
            adapter = groupAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
        }
        binding.recyclerViewV.apply {
            adapter = groupAdapter2
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)

        }
        statisticsSection.update(statisticsBodyList)
        chargesSection.update(nearBySuperChargesList)

        binding.motionLayout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionStarted(motionLayout: MotionLayout, startId: Int, endId: Int) {
                // Handle the start of the drag event

            }

            override fun onTransitionChange(
                motionLayout: MotionLayout,
                startId: Int,
                endId: Int,
                progress: Float
            ) {
                if (progress > 0.5) {
                    binding.titleTv.text = "Tesla Model X"
                    binding.titleTv.textSize = 14f
                    binding.endOfChargeTimeTv.text = "charging"
                    binding.endOfChargeTimeTv.textSize = 12f

                } else {
                    binding.titleTv.text = "Charging your car"
                    binding.titleTv.textSize = 24f
                    binding.endOfChargeTimeTv.text = getString(R.string.end_of_charge_time, "20%")
                    binding.endOfChargeTimeTv.textSize = 14f
                }

            }

            override fun onTransitionCompleted(motionLayout: MotionLayout, currentId: Int) {
               Log.d("Main", "$currentId")
            }




            override fun onTransitionTrigger(
                motionLayout: MotionLayout?,
                triggerId: Int,
                positive: Boolean,
                progress: Float
            ) {
                Log.d("Main", "$progress")
            }
        })
    }
}