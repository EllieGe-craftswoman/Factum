package com.ellies.factum.counter

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.ellies.factum.databinding.ActivityCounterBinding
import com.ellies.mvvm.BaseVMActivity

class CounterActivity : BaseVMActivity() {

    private lateinit var counterViewModel: CounterBaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  setContentView(R.layout.activity_counter)

        counterViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(CounterBaseViewModel::class.java)

/*      val activityCounterBinding: ActivityCounterBinding = DataBindingUtil.setContentView<ActivityCounterBinding>(this,
            R.layout.activity_counter
        )
        activityCounterBinding.viewmodel = counterViewModel*/

        val binding = ActivityCounterBinding.inflate(layoutInflater)

        binding.apply {
            lifecycleOwner = this@CounterActivity
            vm = counterViewModel
        }

        setContentView(binding.root)

    }
}