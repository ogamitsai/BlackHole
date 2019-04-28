package com.ogami.main

import android.app.Application
import android.os.Bundle
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.TranslateAnimation
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {


    val anim by lazy { AnimationUtils.loadAnimation(applicationContext, R.anim.translate_test) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


    }


    fun setCustomDenity(activity: AppCompatActivity , application: Application){
        val appDisplayMetrics = application.resources.displayMetrics

        val targetDensity = appDisplayMetrics.widthPixels / 360
        appDisplayMetrics.density = appDisplayMetrics.scaledDensity

    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
    }
}
