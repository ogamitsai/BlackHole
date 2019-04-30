package com.ogami.commonlib.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job


/**
 * @description
 * @author Ogami
 * @create 2019-04-30 11:28
 **/
open class BaseViewModel : ViewModel() {

    val httpScope: CoroutineScope by lazy {
        CoroutineScope(Dispatchers.Main + Job())
    }



}