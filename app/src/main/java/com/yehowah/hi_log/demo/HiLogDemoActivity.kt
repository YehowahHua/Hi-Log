package com.yehowah.hi_log.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.yehowah.hi_log.R
import com.yehowah.hi_log.R.layout.activity_hi_log_demo
import com.yehowah.hilibrary.log.*

class HiLogDemoActivity : AppCompatActivity() {
    var viewPrinter: HiViewPrinter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_hi_log_demo)
        viewPrinter = HiViewPrinter(this)
        findViewById<View>(R.id.btn_log).setOnClickListener {
            printLog()
        }
        viewPrinter!!.viewProvider.showFloatingView()//展示悬浮窗口显示log
    }

    private fun printLog() {
        HiLogManager.getInstance().addPrinter(viewPrinter)
        HiLog.log(object : HiLogConfig() {
            override fun includeThread(): Boolean {
                return true
            }

            override fun stackTraceDepth(): Int {
                return 0
            }
        }, HiLogType.E, "----TAG---", "5566")
        HiLog.a("1111", "2222", 11, 22)

        //自定义Log配置
//        HiLog.log(object : HiLogConfig(){})
    }
}