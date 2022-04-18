package com.ellies.factum.home

import androidx.lifecycle.MutableLiveData
import com.ellies.mvvm.BaseViewModel

class MainBaseViewModel : BaseViewModel() {

    val goToCounterScreenClicked = MutableLiveData<Boolean>()
    val goToGoalsScreenClicked = MutableLiveData<Boolean>()

    fun goToCounterScreen() {
        goToCounterScreenClicked.value = true
    }

    fun goToGoalsScreen() {
        goToGoalsScreenClicked.value = true
    }
}
