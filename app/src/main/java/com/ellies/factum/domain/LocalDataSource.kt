package com.ellies.factum.domain

import com.ellies.factum.ui.goals.FactumUIModel
import com.ellies.factum.ui.goals.RealmDataItem
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalDataSource(
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
) {
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

    suspend fun getFactumList(): List<FactumUIModel> {
        withContext(defaultDispatcher) {
            realm.query<RealmDataItem>().asFlow().collect {

            }
        }
    }

    suspend fun saveDummyData(factumList: List<RealmDataItem>) {
        withContext(defaultDispatcher) {
            for (realmDataItem in factumList) {
                realm.writeBlocking {
                    copyToRealm(realmDataItem)
                }
            }
        }
    }

}
