package com.ogami.blackhole

import android.os.Bundle
import android.view.View
import com.apkfuns.logutils.LogUtils
 import com.ogami.commonlib.android.startActivityByEx
import com.ogami.commonlib.aop.annotation.SingleClick
import com.ogami.commonlib.base.BaseActivity
import kotlinx.android.synthetic.main.activity_second.*


/**
 * @description
 * @author Ogami
 * @create 2019-04-30 19:52
 **/
class SecondActivity : BaseActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        llContent.setOnClickListener(this)
    }


    @SingleClick
    override fun onClick(v: View?) {
        LogUtils.tag("ogami").i("click")

    }
}