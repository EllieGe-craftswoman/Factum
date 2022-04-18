package com.ellies.factum.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.ellies.factum.goals.FactumListActivity
import com.ellies.factum.counter.CounterActivity
import com.ellies.factum.databinding.ActivityMainBinding
import com.ellies.mvvm.BaseVMActivity

class MainActivity : BaseVMActivity() {

    private lateinit var mainViewModel: MainBaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(MainBaseViewModel::class.java)
        //    setContentView(R.layout.activity_main)


/*

        val activityMainBinding: ActivityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this,
            R.layout.activity_main
        )
        activityMainBinding.viewmodel = mainViewModel
*/

        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            lifecycleOwner = this@MainActivity
            vm = mainViewModel
        }
        setContentView(binding.root)

        Log.d("Hello", "m")

        mainViewModel.goToCounterScreenClicked.observe(this) {
            startActivity(Intent(this, CounterActivity::class.java))
        }
        mainViewModel.goToGoalsScreenClicked.observe(this) {
            startActivity(Intent(this, FactumListActivity::class.java))
        }
    }
}