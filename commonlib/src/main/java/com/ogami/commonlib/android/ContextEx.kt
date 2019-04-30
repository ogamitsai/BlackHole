package com.ogami.commonlib.android

import android.app.Activity
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ogami.commonlib.R

/**
 * @description
 * @author Ogami
 * @create 2019-04-30 19:50
 **/


inline fun <reified T : Activity> Context.startActivityByEx(bundle: Bundle? = null) {
    val intent = Intent(this, T::class.java)
    if (bundle != null) {
        intent.putExtras(bundle)
    }
    startActivity(intent)
}

inline fun <reified T : Service> Context.startServiceByEx(bundle: Bundle? = null) {
    val intent = Intent(this, T::class.java)
    if (bundle != null) {
        intent.putExtras(bundle)
    }
    startService(intent)
}

//fun AppCompatActivity.switchFragment(current: Fragment?, targetFg: Fragment, tag: String? = null) {
//    val ft = supportFragmentManager.beginTransaction()
//    current?.run { ft.hide(this) }
//    if (!targetFg.isAdded) {
//        tag?.run {
//            ft.add(R.id.container, targetFg, tag)
//        } ?: ft.add(R.id.container, targetFg)
//
//    }
//    ft.show(targetFg)
//    ft.commitAllowingStateLoss()
//}

fun AppCompatActivity.switchFragment(current: Fragment?, targetFg: Fragment, tag: String? = null, res: Int) {
    val ft = supportFragmentManager.beginTransaction()
    current?.run { ft.hide(this) }
    if (!targetFg.isAdded) {
        tag?.run {
            ft.add(res, targetFg, tag)
        } ?: ft.add(res, targetFg)

    }
    ft.show(targetFg)
    ft.commitAllowingStateLoss()
}

fun AppCompatActivity.replaceFragment(id: Int, fragment: Fragment, tag: String = fragment::class.java.simpleName) {
    val ft = supportFragmentManager.beginTransaction()
    ft.replace(id, fragment, tag)
    ft.commitAllowingStateLoss()
}