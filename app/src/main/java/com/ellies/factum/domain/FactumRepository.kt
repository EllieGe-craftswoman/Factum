package com.ellies.factum.domain

import com.ellies.factum.ui.goals.FactumUIModel

interface FactumRepository{
    suspend fun pullFactumList() : List<FactumUIModel>
    suspend fun pushFactumList(list: List<FactumUIModel>)
}