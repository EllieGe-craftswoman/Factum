package com.ellies.factum.ui.goals

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.ellies.factum.databinding.ActivityFactumListBinding
import com.ellies.mvvm.BaseVMActivity

class FactumListActivity : BaseVMActivity() {

    private lateinit var factumListViewModel: FactumListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        factumListViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(FactumListViewModel::class.java)

        val binding = ActivityFactumListBinding.inflate(layoutInflater)

        binding.apply {
            lifecycleOwner = this@FactumListActivity
            vm = factumListViewModel
        }

        setContentView(binding.root)
    }
}