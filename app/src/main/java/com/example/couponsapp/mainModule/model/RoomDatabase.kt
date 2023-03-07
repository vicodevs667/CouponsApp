package com.example.couponsapp.mainModule.model

import android.database.sqlite.SQLiteConstraintException
import com.example.couponsapp.CouponsApplication
import com.example.couponsapp.common.dataAccess.CouponDao
import com.example.couponsapp.common.entities.CouponEntity
import com.example.couponsapp.common.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/****
 * Project: CouponsApp
 * From: com.example.couponsapp.mainModule.model
 * Created by: Victor Sanjines Lopez on 7/3/2023 at 11:37
 * More info: www.relativity.com.bo
 * All rights reserved 2022
 ****/
class RoomDatabase {
    private val dao: CouponDao by lazy {
        CouponsApplication.database.couponDao()
    }

    suspend fun consultCouponByCode(code: String) = dao.consultCouponByCode(code)

    suspend fun saveCoupon(couponEntity: CouponEntity) = withContext(Dispatchers.IO) {
        try {
            dao.addCoupon(couponEntity)
        } catch (e: Exception) {
            (e as? SQLiteConstraintException)?.let {throw Exception(Constants.ERROR_EXIST)}
            throw Exception(e.message ?: Constants.ERROR_UNKNOW)
        }
    }
}






















