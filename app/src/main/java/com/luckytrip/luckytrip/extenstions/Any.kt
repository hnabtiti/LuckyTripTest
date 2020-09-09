package com.luckytrip.luckytrip.extenstions

import com.luckytrip.luckytrip.logger.Logger
import com.luckytrip.luckytrip.logger.Tag

val logger by lazy {
    Logger()
}
fun Any.logDebug(msg: String, tag: Tag = Tag.DEFAULT_TAG) {
    logger.logDebug(msg, tag)
}

fun Any.logError(msg: String?, tag: Tag = Tag.DEFAULT_TAG) {
    logger.logError("$msg", tag)
}

fun Any.logExecution(exception: Throwable) {
    logger.logExecution(exception)

}

fun Any.logWTF(msg: String, tag: Tag = Tag.DEFAULT_TAG) {
    logger.logWTF(msg, tag)
}