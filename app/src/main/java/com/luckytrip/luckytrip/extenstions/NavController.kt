package com.luckytrip.luckytrip.extenstions

import android.os.Bundle
import androidx.navigation.NavController

fun NavController.tryNavigate(resId: Int, args: Bundle? = null) {
    try {
        navigate(resId, args)
    } catch (e: Exception) {
        logError(e.message)
    }
}