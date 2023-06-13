package com.example.jucrchallenge.model

data class NearBySuperchargesModel(
    val address: String,
    val distance: String,
    val availability: String
) {
    companion object {
        val sampleList = listOf<NearBySuperchargesModel>(
            NearBySuperchargesModel("RanchView Dr. Richardson", "12km", "5"),
            NearBySuperchargesModel("Thornridge Cir. Shiloh", "12km", "8"),
            NearBySuperchargesModel("Elgin St. Calina", "12km", "9"),
            NearBySuperchargesModel("RanchView Dr. Richardson", "12km", "5"),
            NearBySuperchargesModel("RanchView Dr. Richardson", "12km", "5"),
            NearBySuperchargesModel("RanchView Dr. Richardson", "12km", "5")
        )
    }
}