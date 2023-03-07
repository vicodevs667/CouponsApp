package com.example.couponsapp

import android.app.Application
import androidx.room.Room
import com.example.couponsapp.common.dataAccess.CouponDatabase

/****
 * Project: CouponsApp
 * From: com.example.couponsapp
 * Created by: Victor Sanjines Lopez on 7/3/2023 at 11:15
 * More info: www.relativity.com.bo
 * All rights reserved 2022
 ****/
class CouponsApplication: Application() {
    companion object {
        lateinit var database: CouponDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this,
            CouponDatabase::class.java,
            "CouponDatabase")
            .build()
    }
}