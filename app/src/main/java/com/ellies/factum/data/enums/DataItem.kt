package com.ellies.factum.data.enums

data class DataItem(
    val title: String,
    val description: String? = null,
    val duration: Int? = null,
    val category: Category
)