package com.example.jucrchallenge.adapters

import android.view.View
import com.example.jucrchallenge.R
import com.example.jucrchallenge.databinding.NearbySuperchargesItemViewBinding
import com.example.jucrchallenge.databinding.StaticsItemViewBinding
import com.example.jucrchallenge.model.NearBySuperchargesModel
import com.xwray.groupie.viewbinding.BindableItem

class NearbySuperChargesBindItem(val nearBySuperchargesModel: NearBySuperchargesModel):
    BindableItem<NearbySuperchargesItemViewBinding>() {
    override fun bind(viewBinding: NearbySuperchargesItemViewBinding, position: Int) {
        val context = viewBinding.availabilityTv.context
        viewBinding.distanceTv.text = nearBySuperchargesModel.distance
        viewBinding.locationTv.text = nearBySuperchargesModel.address
        viewBinding.availabilityTv.text = context.getString(R.string.availability, nearBySuperchargesModel.availability)
    }

    override fun getLayout(): Int = R.layout.nearby_supercharges_item_view

    override fun initializeViewBinding(view: View): NearbySuperchargesItemViewBinding = NearbySuperchargesItemViewBinding.bind(view)
}