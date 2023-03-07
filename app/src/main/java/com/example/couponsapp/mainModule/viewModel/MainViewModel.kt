package com.example.couponsapp.mainModule.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.couponsapp.R
import com.example.couponsapp.common.entities.CouponEntity
import com.example.couponsapp.common.utils.getMsgErrorByCode
import com.example.couponsapp.mainModule.model.MainRepository
import kotlinx.coroutines.launch

/****
 * Project: CouponsApp
 * From: com.example.couponsapp.mainModule.viewModel
 * Created by: Victor Sanjines Lopez on 7/3/2023 at 11:38
 * More info: www.relativity.com.bo
 * All rights reserved 2022
 ****/
class MainViewModel : ViewModel() {
    private val repository = MainRepository()

    val coupon = MutableLiveData(CouponEntity())

    private val hideKeyboard = MutableLiveData<Boolean>()
    fun isHideKeyboard() = hideKeyboard

    private val snackbarMsg = MutableLiveData<Int>()
    fun getSnackbarMsg() = snackbarMsg

    /*fun consultCouponByCodeOld(code: String) {
        viewModelScope.launch {
            result.value =  repository.consultCouponByCode(code)
        }
    }*/

    fun consultCouponByCode() {
        coupon.value?.code?.let { code ->
            viewModelScope.launch {
                hideKeyboard.value = true
                coupon.value =  repository.consultCouponByCode(code) ?: CouponEntity(code= code, isActive = false)
            }
        }

    }

    fun saveCoupon() {
        coupon.value?.let { couponEntity ->
            viewModelScope.launch {
                hideKeyboard.value = true
                try {
                    couponEntity.isActive = true
                    repository.saveCoupon(couponEntity)
                    consultCouponByCode()
                    snackbarMsg.value = R.string.main_save_success
                } catch (e: Exception) {
                    snackbarMsg.value = getMsgErrorByCode(e.message)
                }
            }
        }
    }

    /*fun saveCouponOld(couponEntity: CouponEntity) {
        viewModelScope.launch {
            try {
                repository.saveCoupon(couponEntity)
                consultCouponByCode(couponEntity.code)
                snackbarMsg.value = R.string.main_save_success
            } catch (e: Exception) {
                snackbarMsg.value = getMsgErrorByCode(e.message)
            }
        }
    }*/

}
























