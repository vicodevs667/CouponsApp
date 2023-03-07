package com.example.couponsapp.common.adapters

import android.view.View
import androidx.databinding.BindingAdapter

/****
 * Project: CouponsApp
 * From: com.example.couponsapp.common.adapters
 * Created by: Victor Sanjines Lopez on 7/3/2023 at 11:36
 * More info: www.relativity.com.bo
 * All rights reserved 2022
 ****/
@BindingAdapter("isGone")
fun bindIsGone(view: View, isGone: Boolean) {
    view.visibility = if (isGone) View.GONE else View.VISIBLE
}