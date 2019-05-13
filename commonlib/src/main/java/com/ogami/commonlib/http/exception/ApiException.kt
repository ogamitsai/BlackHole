package com.ogami.commonlib.http.exception

/**
 * Created by ogami on 2018/4/9.
 */
open class ApiException : Exception {

    var msg: String? = null
    var code: Int? = null

    constructor(exception: Throwable) : super(exception)

    constructor(msg: String?, code: Int?) {
        this.msg = msg
        this.code = code
    }


}