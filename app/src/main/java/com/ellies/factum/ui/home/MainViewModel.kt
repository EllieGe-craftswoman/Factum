package com.ellies.factum.ui.home

import androidx.lifecycle.MutableLiveData
import com.ellies.mvvm.BaseViewModel

class MainViewModel : BaseViewModel() {

    val goToCounterScreenClicked = MutableLiveData<Boolean>()
    val goToGoalsScreenClicked = MutableLiveData<Boolean>()

    fun goToCounterScreen() {
        goToCounterScreenClicked.value = true
    }

    fun goToGoalsScreen() {
        goToGoalsScreenClicked.value = true
    }
}
