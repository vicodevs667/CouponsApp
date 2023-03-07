package com.example.couponsapp.common.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/****
 * Project: CouponsApp
 * From: com.example.couponsapp
 * Created by: Victor Sanjines Lopez on 7/3/2023 at 11:07
 * More info: www.relativity.com.bo
 * All rights reserved 2022
 ****/
@Entity(tableName = "CouponEntity", indices = [Index(value=["code"], unique = true)])
data class CouponEntity(@PrimaryKey(autoGenerate = true) var id: Long = 0,
                        var code: String ="",
                        var description: String = "",
                        var isActive: Boolean = true)
