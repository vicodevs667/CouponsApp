package com.example.couponsapp.common.utils

import org.junit.Assert.*
import org.junit.Test
import com.example.couponsapp.R
import com.example.couponsapp.common.entities.CouponEntity

/****
 * Project: CouponsApp
 * From: com.example.couponsapp.common.utils
 * Created by: Victor Sanjines Lopez on 7/3/2023 at 17:03
 * More info: www.relativity.com.bo
 * All rights reserved 2022
 */
class CouponUtilsKtTest {
    @Test
    fun validateTextCodeSuccessTest() {
        val code = "WELCOME"
        assertTrue(validateTextCode(code))
    }

    @Test
    fun validateTextCodeEmptyFailTest() {
        val code = " "
        assertFalse(validateTextCode(code))
    }

    @Test
    fun validateTextCodeMinLenghtTest() {
        val code = "HOLA"
        assertFalse(validateTextCode(code))
    }

    @Test
    fun validateTextCodeMaxLenghtTest() {
        val code = "HOLA BIENVENIDO AL CURSO"
        assertFalse(validateTextCode(code))
    }

    @Test
    fun getMsgErrorByCodeNullTest() {
        val errorCode = null
        val expectedValue = R.string.error_unknow
        val result = getMsgErrorByCode(errorCode)
        assertEquals("Error al evaluar un null", expectedValue, result)
    }

    @Test
    fun getMsgErrorByCodeExistTest() {
        val errorCode = Constants.ERROR_EXIST
        val expectedValue = R.string.error_unique_code
        val result = getMsgErrorByCode(errorCode)
        assertEquals("Error al evaluar un cupon existente", expectedValue, result)
    }

    @Test
    fun getMsgErrorByCodeLenghtTest() {
        val errorCode = Constants.ERROR_LENGHT
        val expectedValue = R.string.error_invalid_lenght
        val result = getMsgErrorByCode(errorCode)
        assertEquals("Error al evaluar la longitud válida", expectedValue, result)
        assertNotEquals("El recurso no existe", -1, result)
    }

    @Test
    fun checkNotNullCouponTest() {
        val coupon = CouponEntity(code = "ANDROID", description = "Cursos a $9.99 USD")
        assertNotNull("El cupón no debería ser null", coupon)
    }

    @Test
    fun checkGroupSuccessTest() {
        val aNames = arrayOf("Victor", "Daniel", "Mary") //valor actual
        val bNames = arrayOf("Victor", "Daniel", "Mary") //valor esperado
        assertArrayEquals("Los arreglos deberían coincidir, revise sus elementos",
            bNames, aNames)

    }



}