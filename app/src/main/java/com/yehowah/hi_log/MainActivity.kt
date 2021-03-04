package com.yehowah.hi_log

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.yehowah.hi_log.demo.HiLogDemoActivity
import com.yehowah.hiui.tab.bottom.HiTabBottom
import com.yehowah.hiui.tab.bottom.HiTabBottomInfo

/**
 *
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabBottom = findViewById<HiTabBottom>(R.id.tab_bottom)
        val homeInfo = HiTabBottomInfo(
            "首页",
            "fonts/iconfont.ttf",
            getString(R.string.if_name),
            null,
            "#ff656667",
            "#ffd44949"
            )
        tabBottom.setHiTabInfo(homeInfo)


        findViewById<Button>(R.id.go_log_activity_btn).setOnClickListener {
            startActivity( Intent(this,HiLogDemoActivity::class.java))
        }

    }


















}