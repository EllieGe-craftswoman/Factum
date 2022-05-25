package com.ellies.factum.ui.goals

import androidx.databinding.ObservableArrayList
import com.ellies.factum.data.RepositoryImpl
import com.ellies.factum.domain.DummyDataSource
import com.ellies.factum.domain.LocalDataSource
import com.ellies.mvvm.BaseViewModel

class FactumListViewModel : BaseViewModel() {

    val factumList = ObservableArrayList<FactumUIModel>()
    val dataSourceType = DataSourceType.DUMMY

    private val repositoryImpl = RepositoryImpl(DummyDataSource(), LocalDataSource())

    suspend fun fetchData(){
        factumList.clear()
        val fetchedData = repositoryImpl.pullFactumList(dataSourceType)
        if(fetchedData.isEmpty()){
            repositoryImpl.pushFactumList()
        } else {
            factumList.addAll(fetchedData)
        }
    }

}
