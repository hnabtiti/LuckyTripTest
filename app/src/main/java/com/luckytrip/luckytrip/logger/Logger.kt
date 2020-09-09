package com.luckytrip.luckytrip.logger

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.luckytrip.luckytrip.logger.Tag.*


/**
 * this class for responsible for logging any logging service should implemented here ex:Firebase Crashlytics  ..
 */
class Logger {

    fun logDebug(msg: String, tag: Tag = DEFAULT_TAG) {
        longLogDebug(msg)
    }

    private fun longLogDebug(message: String, tag: Tag = DEFAULT_TAG) {
        var message = message
        var i = 0
        val maxLogLength = 3500
        while (message.length > maxLogLength) {
            Log.d(tag.name, message.substring(0, maxLogLength))
            message = message.substring(maxLogLength)
            i++
        }
        Log.d(tag.name, message)
    }

    fun logError(msg: String, tag: Tag = DEFAULT_TAG) {
        CoroutineScope(Dispatchers.IO).launch {
            Log.e(tag.name, msg)
        }
    }

    fun logExecution(exception: Throwable) {
        CoroutineScope(Dispatchers.IO).launch {
            Log.e(EXCEPTION_TAG.name, "$exception")
        }
    }

    fun logWTF(msg: String, tag: Tag = DEFAULT_TAG) {
        CoroutineScope(Dispatchers.IO).launch {
            Log.wtf(tag.name, msg)
        }
    }
}
