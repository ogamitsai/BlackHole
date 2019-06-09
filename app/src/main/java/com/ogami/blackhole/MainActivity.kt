package com.ogami.blackhole

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ogami.commonlib.android.startActivityByEx
import com.ogami.commonlib.base.BaseActivity
import com.ogami.commonlib.coroutine.tryCatch
import com.ogami.commonlib.http.ApiService
import com.ogami.commonlib.http.ApiFactory
import com.ogami.commonlib.rx.async
import com.ogami.commonlib.rx.handleResult
import kotlinx.android.synthetic.main.activity_main.*

/**
 *  第一个 个人App 刚好发布第一张黑洞照片 所以取名叫黑洞
 */
class MainActivity : BaseActivity() {


//    val vm by lazy { ViewModelProviders.of(this).get(MainViewModel::class.java) }

    val list by lazy { listOf(TestFragment(), SecondFragment()) }

    val mTitle = listOf("tab1", "tab2")

    val mAdapter by lazy {
        object : FragmentStateAdapter(this) {
            override fun createFragment(position: Int): Fragment {
                return list[position]
            }

            override fun getItemCount(): Int {
                return list.size
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_this.adapter = mAdapter


        startActivityByEx<SecondActivity>()


    }


    fun backLambda(del: De): (Order) -> Double {

        if (del == De.STA) return { order -> order.count * 1.3 }

        return { order -> order.count * 1.2 }
    }


}

enum class De {
    STA, EXP
}

class Order(val count: Int)


interface sakula {

    fun sing()
}


class gayama(val mo: Ogami = Ogami()) : sakula by mo {

}


class Ogami : sakula {

    override fun sing() {


    }


}