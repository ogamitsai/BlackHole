package com.ogami.blackhole

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.apkfuns.logutils.LogUtils
import com.ogami.commonlib.android.startActivityByEx
import com.ogami.commonlib.base.BaseActivity
import com.ogami.commonlib.http.ApiService
import com.ogami.commonlib.http.ApiFactory
import kotlinx.android.synthetic.main.activity_main.*

/**
 *  第一个 个人App 刚好发布第一张黑洞照片 所以取名叫黑洞
 */
class MainActivity : BaseActivity() {


//    val vm by lazy { ViewModelProviders.of(this).get(MainViewModel::class.java) }

    val list by lazy { listOf(TestFragment(), SecondFragment()) }

    val mTitle = listOf("tab1","tab2")

    val mAdapter by lazy { object : FragmentStateAdapter(this) {
        override fun getItem(position: Int): Fragment {
            return list[position]
        }

        override fun getItemCount(): Int {
            return list.size
        }
    } }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_this.adapter = mAdapter


        tb_this.setupWithViewPager2(tv_this,mTitle)


    }
}
