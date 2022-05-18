package com.ellies.factum.ui.goals

import io.realm.RealmObject

open class RealmDataItem : RealmObject {
    var title: String = ""
    var description: String? = null
    var duration: Int? = null
    private var categoryString: String? = null
    var category: Category
        get() {
            return try {
                Category.valueOf(categoryString ?: "")
            } catch (ex: IllegalArgumentException) {
                Category.HEADER
            }
        }
        set(value) {
            categoryString = value.name
        }
}