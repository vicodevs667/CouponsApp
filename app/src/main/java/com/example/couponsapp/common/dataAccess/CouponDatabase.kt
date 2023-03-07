package com.example.couponsapp.common.dataAccess

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.couponsapp.common.entities.CouponEntity

/****
 * Project: CouponsApp
 * From: com.example.couponsapp
 * Created by: Victor Sanjines Lopez on 7/3/2023 at 11:13
 * More info: www.relativity.com.bo
 * All rights reserved 2022
 ****/
@Database(entities = [CouponEntity::class], version = 1)
abstract class CouponDatabase: RoomDatabase() {
    abstract fun couponDao(): CouponDao
}