package com.ellies.factum.domain

import com.ellies.factum.ui.goals.FactumUIModel

interface DataSource {
    suspend fun getFactumList(): List<FactumUIModel>
}