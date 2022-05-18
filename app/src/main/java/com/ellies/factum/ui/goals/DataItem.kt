package com.ellies.factum.ui.goals

data class DataItem(
    val title: String,
    val description: String? = null,
    val duration: Int? = null,
    val category: Category
)