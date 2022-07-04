package com.ellies.factum.ui.goals

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.viewModelScope
import com.ellies.factum.data.FactumRepositoryImpl
import com.ellies.factum.data.source.dummy.DummyDataSource
import com.ellies.factum.data.source.local.LocalDataSource
import com.ellies.mvvm.BaseViewModel
import kotlinx.coroutines.launch

class FactumListViewModel : BaseViewModel() {

    val factumList = ObservableArrayList<FactumUIModel>()

    private val repositoryImpl = FactumRepositoryImpl(DummyDataSource(), LocalDataSource())

    init {
        viewModelScope.launch {
            fetchData()
        }
    }
    private suspend fun fetchData(){
        factumList.clear()
        val fetchedData = repositoryImpl.pullFactumList()
        factumList.addAll(fetchedData)
    }

}
