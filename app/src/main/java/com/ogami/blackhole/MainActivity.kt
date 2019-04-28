package com.ogami.blackhole

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ogami.commonlib.arouter.ArouterPatch
import com.ogami.commonlib.arouter.startActivityByARouter
import com.ogami.commonlib.base.BaseActivity

/**
 *  第一个 个人App 刚好发布第一张黑洞照片 所以取名叫黑洞
 */
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Thread {
            Thread.sleep(2000)

            runOnUiThread {
                startActivityByARouter(ArouterPatch.HomeActivity)
            }

        }.start()


    }


}
