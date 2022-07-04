package com.ellies.factum.data.source.local

import com.ellies.factum.data.map
import com.ellies.factum.data.mapToRealmList
import com.ellies.factum.data.mapToUIModelList
import com.ellies.factum.domain.DataSource
import com.ellies.factum.ui.goals.FactumUIModel
import com.ellies.factum.ui.goals.RealmDataItem
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalDataSource(
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
) : DataSource {
    lateinit var config: RealmConfiguration
    lateinit var realm: Realm

    init {
        openRealm()
    }

    private fun openRealm() {
        config = RealmConfiguration.Builder(schema = setOf(RealmDataItem::class))
            .build()
        realm = Realm.open(config)
    }

    override suspend fun getFactumList(): List<FactumUIModel> {
        return withContext(defaultDispatcher) {
            realm.query(RealmDataItem::class).find().map().mapToUIModelList()
        }
    }

    suspend fun saveDummyData(factumList: List<FactumUIModel>) {
        withContext(defaultDispatcher) {
            for (realmDataItem in factumList.mapToRealmList()) {
                realm.writeBlocking {
                    copyToRealm(realmDataItem)
                }
            }
        }
    }

}
