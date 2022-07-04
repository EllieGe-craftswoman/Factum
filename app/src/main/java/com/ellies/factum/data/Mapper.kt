package com.ellies.factum.data

import com.ellies.factum.data.enums.Category
import com.ellies.factum.data.enums.DataItem
import com.ellies.factum.ui.goals.FactumUIModel
import com.ellies.factum.ui.goals.RealmDataItem

@JvmName("mapRealmDataItem")
fun List<RealmDataItem>.map() : List<DataItem> {
    val list = mutableListOf<DataItem>()
    for (item in this){
        list.add(item.map())
    }
    return list
}

fun RealmDataItem.map() : DataItem = DataItem(
    this.title,
    this.description,
    this.duration,
    this.category)

fun List<DataItem>.mapToUIModelList(): List<FactumUIModel> {
    val result = mutableListOf<FactumUIModel>()
    val groupedData = this.groupBy { it.category }
    groupedData.keys.forEach { category ->
        result.add(FactumUIModel.HeaderUIModel(category.readableText))
        val list = groupedData[category]
        list?.forEach {
            when (category) {
                Category.TO_READ -> result.add(
                    FactumUIModel.ToReadUIModel(
                        it.title,
                        it.description
                    )
                )
                Category.TO_WATCH -> result.add(
                    FactumUIModel.ToWatchUIModel(
                        it.title,
                        it.duration
                    )
                )
                else -> {/*DO NOTHING*/}
            }
        }
    }
    return  result
}

fun List<FactumUIModel>.mapToRealmList(): List<RealmDataItem> {
    val result = mutableListOf<RealmDataItem>()
    for (item in this){
        item.map()?.let { result.add(it) }
    }
    return  result
}

fun FactumUIModel.map(): RealmDataItem? {
    return when(val uiModel = this){
        is FactumUIModel.ToReadUIModel -> RealmDataItem().apply {
            this.title = uiModel.title
            description = uiModel.description
            category = uiModel.category
        }
        is FactumUIModel.ToWatchUIModel -> RealmDataItem().apply {
            this.title = uiModel.title
            duration = uiModel.duration
            category = uiModel.category
        }
        else -> null
    }
}
