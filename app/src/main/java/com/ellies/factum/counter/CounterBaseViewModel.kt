package com.ellies.factum.counter

import androidx.databinding.ObservableInt
import com.ellies.mvvm.BaseViewModel

class CounterBaseViewModel() : BaseViewModel() {

    val clicks = ObservableInt(0)

    fun incrementCount() {
        clicks.set(clicks.get() + 1)
    }

}
