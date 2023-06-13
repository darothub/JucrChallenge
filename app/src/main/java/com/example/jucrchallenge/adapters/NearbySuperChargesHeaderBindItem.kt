package com.example.jucrchallenge.adapters

import android.view.View
import com.example.jucrchallenge.R
import com.example.jucrchallenge.databinding.ChargesHeaderItemBinding
import com.xwray.groupie.viewbinding.BindableItem

class NearbySuperChargesHeaderBindItem(val header: String = "Nearby Supercharges"): BindableItem<ChargesHeaderItemBinding>() {
    override fun bind(viewBinding: ChargesHeaderItemBinding, position: Int) {
        viewBinding.title.text = header
    }
    override fun getLayout(): Int = R.layout.charges_header_item

    override fun initializeViewBinding(view: View): ChargesHeaderItemBinding = ChargesHeaderItemBinding.bind(view)
}