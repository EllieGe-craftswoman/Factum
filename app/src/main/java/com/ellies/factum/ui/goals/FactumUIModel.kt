package com.ellies.factum.ui.goals

import com.ellies.factum.R
import com.ellies.factum.data.enums.Category
import com.ellies.factum.data.enums.DataItem
import com.ellies.mvvm.BaseItemUIModel


sealed class FactumUIModel: BaseItemUIModel<DataItem>() {
    abstract val layoutId: Int
    abstract val category: Category

    class HeaderUIModel(val title: String) : FactumUIModel() {
        override val layoutId: Int
            get() = R.layout.item_header
        override val category: Category
            get() = Category.HEADER
    }

    class ToReadUIModel(val title: String, val description: String?) :
        FactumUIModel() {
        override val layoutId: Int
            get() = R.layout.item_to_read
        override val category: Category
            get() = Category.TO_READ

    }

    class ToWatchUIModel(val title: String, val duration: Int?) :
        FactumUIModel() {
        override val layoutId: Int
            get() = R.layout.item_to_watch
        override val category: Category
            get() = Category.TO_WATCH

    }

}
