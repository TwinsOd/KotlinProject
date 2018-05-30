@file:JvmName("DateUtils")

package com.imangazaliev.notelin.utils

import java.text.SimpleDateFormat
import java.util.*

fun formatDate(date: Date?): String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
    return if (date == null)
        "data is null"
    else
        dateFormat.format(date)
}