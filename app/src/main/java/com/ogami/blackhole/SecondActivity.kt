package com.ogami.blackhole

import android.os.Bundle
import com.ogami.commonlib.android.startActivityByEx
import com.ogami.commonlib.base.BaseActivity
import com.ogami.commonlib.coroutine.launch


/**
 * @description
 * @author Ogami
 * @create 2019-04-30 19:52
 **/
class SecondActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        launch(3000) {
            startActivityByEx<MainActivity>()


        }
    }
}