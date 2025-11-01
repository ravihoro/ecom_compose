package com.example.ecom.core.utils

import java.text.DecimalFormat

fun Double.toPriceString(): String {
    val formatter = DecimalFormat("#,##0.00")
    return formatter.format(this)
}