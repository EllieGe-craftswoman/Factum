package com.ellies.mvvm.recyclerview

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.ellies.mvvm.BaseItemUIModel


abstract class RecyclerViewAdapterByE<ITEM_T, VIEW_MODEL_T : BaseItemUIModel<ITEM_T>> :
    RecyclerView.Adapter<RecyclerViewAdapterByE.BindableItemViewHolder<ITEM_T>>() {

    var itemItemUIModels: ArrayList<BaseItemUIModel<ITEM_T>> = ArrayList()
    protected val viewTypeToLayoutId: MutableMap<Int, Int> = mutableMapOf()

    override fun onBindViewHolder(holderBindable: BindableItemViewHolder<ITEM_T>, position: Int) {
        holderBindable.bind(itemItemUIModels[position])
    }

    override fun getItemCount(): Int {
        return itemItemUIModels.size
    }

    abstract class BindableItemViewHolder<T>(
        binding: ViewDataBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        abstract fun bind(itemUIModel: BaseItemUIModel<T>)
    }

}