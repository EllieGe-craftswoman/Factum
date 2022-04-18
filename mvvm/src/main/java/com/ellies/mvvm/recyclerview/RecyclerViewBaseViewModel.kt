package com.ellies.mvvm.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.ellies.mvvm.BaseItemUIModel
import com.ellies.mvvm.BaseViewModel

/*

public abstract class RecyclerViewBaseViewModel: BaseViewModel() {

    lateinit var layoutManager : RecyclerView.LayoutManager

    protected abstract fun getAdapter() : RecyclerViewAdapterByE<Any, BaseItemUIModel<Any>>
    protected abstract fun createLayoutManager() : RecyclerView.LayoutManager


    fun setupRecyclerView(recyclerView: RecyclerView) {
        layoutManager = createLayoutManager()
        recyclerView.adapter = getAdapter()
        recyclerView.layoutManager = layoutManager
    }


}
*/
