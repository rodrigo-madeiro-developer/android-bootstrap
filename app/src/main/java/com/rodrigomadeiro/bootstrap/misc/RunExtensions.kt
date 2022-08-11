package com.rodrigomadeiro.bootstrap.misc

import timber.log.Timber

inline fun <T, R> T.runSafely(block: T.() -> R): R? {
    return try {
        block()
    } catch (e: Exception) {
        Timber.e(e)
        null
    }
}

inline fun <T, R> T.runQuietly(block: T.() -> R): R? {
    return try {
        block()
    } catch (e: Exception) {
        null
    }
}