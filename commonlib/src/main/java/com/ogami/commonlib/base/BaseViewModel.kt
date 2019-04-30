package com.ogami.commonlib.base

import androidx.lifecycle.ViewModel
import com.apkfuns.logutils.LogUtils
import com.ogami.commonlib.coroutine.coroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel


/**
 * @description
 * @author Ogami
 * @create 2019-04-30 11:28
 **/
open class BaseViewModel : ViewModel() {

    val vmScope: CoroutineScope by lazy {
        CoroutineScope(coroutineDispatcher)
    }



    override fun onCleared() {
        super.onCleared()
        vmScope.cancel()
    }



}