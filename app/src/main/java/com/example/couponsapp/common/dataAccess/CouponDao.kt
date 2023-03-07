package com.example.couponsapp.common.dataAccess

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.couponsapp.common.entities.CouponEntity

/****
 * Project: CouponsApp
 * From: com.example.couponsapp
 * Created by: Victor Sanjines Lopez on 7/3/2023 at 11:10
 * More info: www.relativity.com.bo
 * All rights reserved 2022
 ****/
@Dao
interface CouponDao {
    @Query("SELECT * FROM CouponEntity WHERE code = :code")
    suspend fun consultCouponByCode(code: String): CouponEntity?

    @Insert
    suspend fun addCoupon(couponEntity: CouponEntity): Long
}