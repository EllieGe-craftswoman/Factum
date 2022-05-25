package com.ellies.factum.data

import com.ellies.factum.data.enums.Category
import com.ellies.factum.data.enums.DataItem
import com.ellies.factum.ui.goals.FactumUIModel
import com.ellies.factum.ui.goals.RealmDataItem

fun List<DataItem>.map() : List<RealmDataItem> {
    val list = mutableListOf<RealmDataItem>()
    for (item in this){
        list.add(item.map())
    }
    return list
}

fun DataItem.map() : RealmDataItem {
    val dataItem = this
    return RealmDataItem().apply {
        title = dataItem.title
        description = dataItem.description
        duration = dataItem.duration
        category = dataItem.category
    }
}

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
                Category.HEADER -> {/*TODO*/}
            }
        }
    }
    return  result
}