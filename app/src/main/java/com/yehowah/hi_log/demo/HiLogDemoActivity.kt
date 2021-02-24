package com.yehowah.hi_log.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.yehowah.hi_log.R
import com.yehowah.hi_log.R.layout.activity_hi_log_demo
import com.yehowah.hilibrary.log.HiLog
import com.yehowah.hilibrary.log.HiLogConfig
import com.yehowah.hilibrary.log.HiViewPrinter

class HiLogDemoActivity : AppCompatActivity() {
    var viewPrinter: HiViewPrinter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_hi_log_demo)
        viewPrinter = HiViewPrinter(this)
        findViewById<View>(R.id.btn_log).setOnClickListener{
            printLog()
        }
        viewPrinter!!.viewProvider.showFloatingView()
    }

    private fun printLog() {
        HiLog.a("1111","2222",11,22)

        //自定义Log配置
//        HiLog.log(object : HiLogConfig(){})
    }
}