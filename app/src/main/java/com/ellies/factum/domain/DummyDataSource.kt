package com.ellies.factum.domain

import com.ellies.factum.data.enums.Category
import com.ellies.factum.data.enums.DataItem

class DummyDataSource {
    fun getFactumList(): List<DataItem> {
        val dataItems = mutableListOf<DataItem>()
        dataItems.apply {
            add(
                DataItem(
                    title = "The Software Crafstman",
                    description = "The Software Craftsman defines the Software Craftsmanship ideology and what it means to be a professional software developer.",
                    category = Category.TO_READ
                )
            )
            add(DataItem(title = "The Mind Explained", duration = 90, category = Category.TO_WATCH))
            add(
                DataItem(
                    title = "The Raincoat Killer (2021)",
                    duration = 190,
                    category = Category.TO_WATCH
                )
            )
            add(
                DataItem(
                    title = "Clean Code: A Handbook of Agile Software Craftsmanship",
                    description = "In this book Robert C. Martin (aka. ‘Uncle Bob’) presents a critical view on established programming paradigms and supposed best practices.",
                    category = Category.TO_READ
                )
            )
            add(
                DataItem(
                    title = "Design Patterns: Elements Of Reusable Object Oriented Software",
                    description = "After many years this is still the gold standard literature about software design patterns. Many developers know only a small number of those patterns.",
                    category = Category.TO_READ
                )
            )
            add(
                DataItem(
                    title = "March of the Penguins",
                    duration = 180,
                    category = Category.TO_WATCH
                )
            )
            add(DataItem(title = "Minding the Gap", duration = 200, category = Category.TO_WATCH))
            add(
                DataItem(
                    title = "War and Peace",
                    description = "Epic in scale, War and Peace delineates in graphic detail events leading up to Napoleon's invasion of Russia, and the impact of the Napoleonic era on Tsarist society, as seen through the eyes of fi..",
                    category = Category.TO_READ
                )
            )
            add(
                DataItem(
                    title = "Won't You Be My Neighbor?",
                    duration = 95,
                    category = Category.TO_WATCH
                )
            )
            add(
                DataItem(
                    title = "This Is a Robbery (2021)",
                    duration = 80,
                    category = Category.TO_WATCH
                )
            )
        }
        return dataItems
    }
}


