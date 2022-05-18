package com.ellies.factum.ui.goals

import com.ellies.factum.R
import com.ellies.mvvm.BaseItemUIModel

//TODO: NO NEED TO REFERENCE DATA ITEM HERE
sealed class FactumUIModel : BaseItemUIModel<DataItem>() {
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
