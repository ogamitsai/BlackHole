package com.ogami.blackhole

import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.*
import com.google.android.material.tabs.TabLayout
import com.ogami.blackhole.TabLayoutMediator.selectTab
import com.ogami.blackhole.TabLayoutMediator.setScrollPosition
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ref.WeakReference

/**
 * @description tablayout 扩展
 * @author Ogami
 * @create 2019-05-11 12:26
 **/

fun TabLayout.setupWithViewPager2(vp: ViewPager2, title : List<String>) {

    TabLayoutMediator(this, vp) { tab, position ->
        tab.text = title[position]
    }.attach()

}

