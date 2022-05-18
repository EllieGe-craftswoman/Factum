package com.ellies.factum.ui.counter

import androidx.databinding.ObservableInt
import com.ellies.mvvm.BaseViewModel

class CounterViewModel : BaseViewModel() {

    val clicks = ObservableInt(0)

    fun incrementCount() {
        clicks.set(clicks.get() + 1)
    }

}
