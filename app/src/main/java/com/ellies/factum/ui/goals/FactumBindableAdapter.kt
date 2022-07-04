package com.ellies.factum.ui.goals

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.ellies.factum.BR
import com.ellies.factum.data.enums.DataItem
import com.ellies.mvvm.BaseItemUIModel
import com.ellies.mvvm.recyclerview.RecyclerViewAdapterByE

class FactumBindableAdapter : RecyclerViewAdapterByE<DataItem, FactumUIModel>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindableItemViewHolder<DataItem> {
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            viewTypeToLayoutId[viewType] ?: 0,
            parent,
            false
        )
        return BindingVH(binding)
    }

    override fun getItemViewType(position: Int): Int {
        val item = itemItemUIModels[position] as FactumUIModel
        if (!viewTypeToLayoutId.containsKey(item.category.ordinal)) {
            viewTypeToLayoutId[item.category.ordinal] = item.layoutId
        }
        return item.category.ordinal
    }


    class BindingVH(private val binding: ViewDataBinding) :
        BindableItemViewHolder<DataItem>(binding) {
        override fun bind(itemUIModel: BaseItemUIModel<DataItem>) {
            binding.setVariable(BR.itemModel, itemUIModel)
        }
    }

    @Suppress("UNCHECKED_CAST")
    @SuppressLint("NotifyDataSetChanged")
    fun updateItems(items: ArrayList<FactumUIModel>) {
        this.itemItemUIModels = items as ArrayList<BaseItemUIModel<DataItem>>
        notifyDataSetChanged()
    }

}