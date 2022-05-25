package com.ellies.factum.data

import com.ellies.factum.domain.DummyDataSource
import com.ellies.factum.domain.LocalDataSource
import com.ellies.factum.domain.Repository
import com.ellies.factum.ui.goals.DataSourceType
import com.ellies.factum.ui.goals.FactumUIModel


class RepositoryImpl(
    private val dummyDataSource: DummyDataSource,
    private val localDataSource: LocalDataSource,
): Repository {
    override suspend fun pullFactumList(dataSourceType: DataSourceType): List<FactumUIModel> {
        when(dataSourceType){
            DataSourceType.DUMMY -> { return dummyDataSource.getFactumList().mapToUIModelList()}
            DataSourceType.LOCAL_DB -> {
                localDataSource.getFactumList()
            }
        }
    }


    override suspend fun pushFactumList() {
        localDataSource.saveDummyData(dummyDataSource.getFactumList().map())
    }
}