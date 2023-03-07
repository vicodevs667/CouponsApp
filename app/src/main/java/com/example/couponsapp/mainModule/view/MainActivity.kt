package com.example.couponsapp.mainModule.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.couponsapp.BR
import com.example.couponsapp.R
import com.example.couponsapp.common.entities.CouponEntity
import com.example.couponsapp.common.utils.hideKeyword
import com.example.couponsapp.databinding.ActivityMainBinding
import com.example.couponsapp.mainModule.viewModel.MainViewModel
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setupViewModel()
        setupObservers()

    }

    private fun setupViewModel() {
        val vm: MainViewModel by viewModels()
        binding.lifecycleOwner = this
        binding.setVariable(BR.viewModel, vm)
    }

    private fun setupObservers() {
        binding.viewModel?.let {
            it.coupon.observe(this@MainActivity) {coupon ->
                binding.isActive = coupon != null && coupon.isActive
            }
            it.getSnackbarMsg().observe(this@MainActivity) {msg ->
                Snackbar.make(binding.root, msg, Snackbar.LENGTH_SHORT).show()
            }
            it.isHideKeyboard().observe(this@MainActivity) {isHide ->
                if (isHide) hideKeyword(this@MainActivity, binding.root)
            }
        }

    }
}