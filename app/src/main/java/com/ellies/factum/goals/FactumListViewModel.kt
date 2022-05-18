package com.ellies.factum.goals

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.viewModelScope
import com.ellies.factum.goals.FactumUIModel.HeaderUIModel
import com.ellies.factum.goals.FactumUIModel.ToReadUIModel
import com.ellies.factum.goals.FactumUIModel.ToWatchUIModel
import com.ellies.mvvm.BaseViewModel
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.query
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class FactumListViewModel : BaseViewModel() {

    val factumList = ObservableArrayList<FactumUIModel>()

    lateinit var config : RealmConfiguration
    lateinit var realm : Realm

    /* Block To use Local Source for Data - Realm */
    init {
        openRealm()
        fetchDataFromRealm()
    }

    /* Block for loading Dummy Data */
    /*init {
        loadDummyData(DataAction.DISPLAY)
    }*/

    private fun openRealm() {
        config = RealmConfiguration.Builder(schema = setOf(RealmDataItem::class))
            .build()
        realm = Realm.open(config)
    }


    private fun fetchDataFromRealm() {
        /* With Coroutines*/
        //Try to fetch data first
        val fetchALlQuery = realm.query<RealmDataItem>()

        viewModelScope.launch {
            fetchALlQuery.asFlow().collect {
                //If realm data is empty, add data the try to fetch again
                //If not empty add to list
                //TODO: how to add the whole list when flow is completed?
                //TODO: BAD APPROACH TO CALL PREPAREDATA FOR DISPLAY FROM HERE
                if(it.list.isEmpty())
                    loadDummyData(DataAction.SAVE_TO_LOCAL_DATABASE)
                else
                    prepareDataForDisplay(it.list.map())
            }
        }
      /*
        *//*Directly through Realm Object*//*
        //Try to fetch data first
        val fetchALlQuery = realm.query<RealmDataItem>()
        val retrievedRealmData: RealmResults<RealmDataItem> = fetchALlQuery.find()

        //If realm data is empty, add data the try to fetch again
        //If not empty map & display
        if(retrievedRealmData.isEmpty()){
            loadDummyData(DataAction.SAVE_TO_LOCAL_DATABASE)
            fetchDataFromRealm()
        } else {
            prepareDataForDisplay(retrievedRealmData.map())
        }
        */


    }

    private fun loadDummyData(action: DataAction) {
        val dataItems = mutableListOf<DataItem>()

        dataItems.apply {
            add(
                DataItem(
                    title = "The Software Crafstman",
                    description = "The Software Craftsman defines the Software Craftsmanship ideology and what it means to be a professional software developer.",
                    category = Category.TO_READ
                )
            )
            add(DataItem(title = "The Mind Explained", duration = 90, category = Category.TO_WATCH))
            add(
                DataItem(
                    title = "The Raincoat Killer (2021)",
                    duration = 190,
                    category = Category.TO_WATCH
                )
            )
            add(
                DataItem(
                    title = "Clean Code: A Handbook of Agile Software Craftsmanship",
                    description = "In this book Robert C. Martin (aka. ‘Uncle Bob’) presents a critical view on established programming paradigms and supposed best practices.",
                    category = Category.TO_READ
                )
            )
            add(
                DataItem(
                    title = "Design Patterns: Elements Of Reusable Object Oriented Software",
                    description = "After many years this is still the gold standard literature about software design patterns. Many developers know only a small number of those patterns.",
                    category = Category.TO_READ
                )
            )
            add(
                DataItem(
                    title = "March of the Penguins",
                    duration = 180,
                    category = Category.TO_WATCH
                )
            )
            add(DataItem(title = "Minding the Gap", duration = 200, category = Category.TO_WATCH))
            add(
                DataItem(
                    title = "War and Peace",
                    description = "Epic in scale, War and Peace delineates in graphic detail events leading up to Napoleon's invasion of Russia, and the impact of the Napoleonic era on Tsarist society, as seen through the eyes of fi..",
                    category = Category.TO_READ
                )
            )
            add(
                DataItem(
                    title = "Won't You Be My Neighbor?",
                    duration = 95,
                    category = Category.TO_WATCH
                )
            )
            add(
                DataItem(
                    title = "This Is a Robbery (2021)",
                    duration = 80,
                    category = Category.TO_WATCH
                )
            )
        }

        when(action){
            DataAction.DISPLAY -> prepareDataForDisplay(dataItems)
            DataAction.SAVE_TO_LOCAL_DATABASE -> writeDataToRealm(dataItems.map())
        }

    }

    private fun writeDataToRealm(list: List<RealmDataItem>) {
        /* With Coroutines */
         CoroutineScope(context = viewModelScope.coroutineContext).async {
             //TODO: Warning Deferred result is never used
             for(realmDataItem in list){
                realm.writeBlocking {
                   copyToRealm(realmDataItem)
                }
             }
             fetchDataFromRealm()
         }

      /* /*Directly through Realm Object*/
        for(realmDataItem in list){
            realm.writeBlocking {
                copyToRealm(realmDataItem)
            }
        }*/
    }

    private fun prepareDataForDisplay(dataItems: List<DataItem>) {
        val groupedData = dataItems.groupBy { it.category }

        factumList.clear()
        groupedData.keys.forEach { category ->
            factumList.add(HeaderUIModel(category.readableText))
            val list = groupedData[category]
            list?.forEach {
                when (category) {
                    Category.TO_READ -> factumList.add(
                        ToReadUIModel(
                            it.title,
                            it.description
                        )
                    )
                    Category.TO_WATCH -> factumList.add(
                        ToWatchUIModel(
                            it.title,
                            it.duration
                        )
                    )
                    Category.HEADER -> {/*TODO*/}
                }
            }
        }
    }

}
