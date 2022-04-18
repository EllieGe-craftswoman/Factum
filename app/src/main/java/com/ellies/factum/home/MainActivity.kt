package com.ellies.factum.home

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.ellies.factum.goals.FactumListActivity
import com.ellies.factum.counter.CounterActivity
import com.ellies.factum.databinding.ActivityMainBinding
import com.ellies.mvvm.BaseVMActivity

class MainActivity : BaseVMActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(MainViewModel::class.java)
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

        mainViewModel.goToCounterScreenClicked.observe(this) {
            startActivity(Intent(this, CounterActivity::class.java))
        }
        mainViewModel.goToGoalsScreenClicked.observe(this) {
            startActivity(Intent(this, FactumListActivity::class.java))
        }
    }
}