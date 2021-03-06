@file:Suppress("SpellCheckingInspection")

package com.ellies.factum

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ellies.factum.ui.goals.FactumBindableAdapter
import com.ellies.factum.ui.goals.FactumUIModel


class BindingAdapters {

    companion object {

        @JvmStatic
        @BindingAdapter("items")
        fun bindItemViewModels(
            recyclerView: RecyclerView,
            items: ArrayList<FactumUIModel>
        ) {
            val adapter = getOrCreateAdapter(recyclerView)
            adapter.updateItems(items)
        }

        private fun getOrCreateAdapter(recyclerView: RecyclerView): FactumBindableAdapter {
            return if (recyclerView.adapter != null && recyclerView.adapter is FactumBindableAdapter) {
                recyclerView.adapter as FactumBindableAdapter
            } else {
                val factumBindableAdapter = FactumBindableAdapter()
                recyclerView.adapter = factumBindableAdapter
                factumBindableAdapter
            }
        }
    }


}