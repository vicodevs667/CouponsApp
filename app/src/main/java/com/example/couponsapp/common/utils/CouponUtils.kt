package com.example.couponsapp.common.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.couponsapp.R

/****
 * Project: CouponsApp
 * From: com.example.couponsapp.common.utils
 * Created by: Victor Sanjines Lopez on 7/3/2023 at 11:36
 * More info: www.relativity.com.bo
 * All rights reserved 2022
 ****/
fun validateTextCode(code: String): Boolean {
    return !(code.length < 5  || code.length > 10)
}

fun getMsgErrorByCode(errorCode: String?): Int = when(errorCode) {
    Constants.ERROR_EXIST -> R.string.error_unique_code
    Constants.ERROR_LENGHT -> R.string.error_invalid_lenght
    else -> R.string.error_unknow
}

fun hideKeyword(context: Context, view: View) {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
    imm?.hideSoftInputFromWindow(view.windowToken, 0)
}
