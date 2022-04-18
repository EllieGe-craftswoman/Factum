package com.ellies.factum.goals

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.ellies.factum.databinding.ActivityFactumListBinding
import com.ellies.mvvm.BaseVMActivity

class FactumListActivity : BaseVMActivity() {

    private lateinit var factumListViewModel: FactumListBaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_goals)

        factumListViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(FactumListBaseViewModel::class.java)
/*
        val activityGoalsBinding: ActivityGoalsBinding = DataBindingUtil.setContentView<ActivityGoalsBinding>(this,
            R.layout.activity_goals
        )
        activityGoalsBinding.viewmodel = factumListViewModel*/
        val binding = ActivityFactumListBinding.inflate(layoutInflater)

        binding.apply {
            lifecycleOwner = this@FactumListActivity
            vm = factumListViewModel
        }

        setContentView(binding.root)
    }
}