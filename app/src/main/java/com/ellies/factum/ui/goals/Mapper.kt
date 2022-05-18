package com.ellies.factum.ui.goals

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