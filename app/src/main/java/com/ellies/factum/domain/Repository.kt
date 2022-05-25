package com.ellies.factum.domain

import com.ellies.factum.ui.goals.DataSourceType
import com.ellies.factum.ui.goals.FactumUIModel

interface Repository{
    suspend fun pullFactumList(dataSourceType: DataSourceType) : List<FactumUIModel>
    suspend fun pushFactumList(list: List<FactumUIModel>)
}