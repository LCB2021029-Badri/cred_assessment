package com.example.credassessment1

data class NumberItem(
    val word: String,
    val imageResId: Int,
    var isExpanded: Boolean = false  // To track the expanded/collapsed state
)