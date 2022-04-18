package com.ellies.factum.goals

import com.ellies.factum.R
import com.ellies.mvvm.BaseItemUIModel

sealed class FactumUIModelBaseItemUIModel : BaseItemUIModel<DataItem>() {
    abstract val layoutId: Int
    abstract val category: Category

    class HeaderUIModelBaseItemUIModel(val title: String) : FactumUIModelBaseItemUIModel() {
        override val layoutId: Int
            get() = R.layout.item_header
        override val category: Category
            get() = Category.HEADER

    }

    class ToReadUIModelBaseItemUIModel(val title: String, val description: String?) :
        FactumUIModelBaseItemUIModel() {
        override val layoutId: Int
            get() = R.layout.item_to_read
        override val category: Category
            get() = Category.TO_READ

    }

    class ToWatchUIModelBaseItemUIModel(val title: String, val duration: Int?) :
        FactumUIModelBaseItemUIModel() {
        override val layoutId: Int
            get() = R.layout.item_to_watch
        override val category: Category
            get() = Category.TO_WATCH

    }

}
