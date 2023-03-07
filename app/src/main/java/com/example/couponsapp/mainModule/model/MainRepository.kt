package com.example.couponsapp.mainModule.model

import com.example.couponsapp.common.entities.CouponEntity
import com.example.couponsapp.common.utils.Constants
import com.example.couponsapp.common.utils.validateTextCode

/****
 * Project: CouponsApp
 * From: com.example.couponsapp.mainModule.model
 * Created by: Victor Sanjines Lopez on 7/3/2023 at 11:37
 * More info: www.relativity.com.bo
 * All rights reserved 2022
 ****/
class MainRepository {
    private val roomDatabase = RoomDatabase()

    suspend fun consultCouponByCode(code: String) = roomDatabase.consultCouponByCode(code)

    suspend fun saveCoupon(couponEntity: CouponEntity) {
        if (validateTextCode(couponEntity.code)) {
            roomDatabase.saveCoupon(couponEntity)
        } else {
            throw Exception(Constants.ERROR_LENGHT)
        }
    }
}