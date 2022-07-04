package com.ellies.factum.data

import com.ellies.factum.data.source.dummy.DummyDataSource
import com.ellies.factum.data.source.local.LocalDataSource
import com.ellies.factum.domain.FactumRepository
import com.ellies.factum.ui.goals.FactumUIModel


class FactumRepositoryImpl(
    private val dummyDataSource: DummyDataSource,
    private val localDataSource: LocalDataSource,
): FactumRepository {
    override suspend fun pullFactumList(): List<FactumUIModel> {
        return if(localDataSource.getFactumList().isNullOrEmpty()){
            val dummyData = dummyDataSource.getFactumList()
            localDataSource.saveDummyData(dummyData)
            dummyData
        } else {
            localDataSource.getFactumList()
        }
    }

    override suspend fun pushFactumList(list: List<FactumUIModel>) {
        localDataSource.saveDummyData(dummyDataSource.getFactumList())
    }

}