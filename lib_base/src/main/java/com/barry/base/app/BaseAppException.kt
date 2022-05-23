package com.barry.base.app

import com.barry.base.extensions.logger
import com.orhanobut.logger.Logger

/*************************
 * @Machine: RedmiBook Pro 15 Win11
 * @Path: lib_base/src/main/java/cn/barry/base/app
 * @Time: 2022/5/8 18:11
 * @Author: BarryAllen
 * @Description: BaseAppException
 **************************/

class BaseAppException : Thread.UncaughtExceptionHandler {

    override fun uncaughtException(t: Thread, e: Throwable) {
        val exception = e.stackTraceToString()
        exception.logger(Logger.ERROR)
    }
}