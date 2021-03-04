package com.yehowah.hi_log

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.yehowah.hi_log.demo.HiLogDemoActivity
import com.yehowah.hi_log.demo.tab.HiTabBottomDemoActivity
import com.yehowah.hiui.tab.bottom.HiTabBottom
import com.yehowah.hiui.tab.bottom.HiTabBottomInfo

/**
 *
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        findViewById<Button>(R.id.go_log_activity_btn).setOnClickListener {
            startActivity( Intent(this,HiLogDemoActivity::class.java))
        }
        findViewById<Button>(R.id.go_tab_activity_btn).setOnClickListener {
            startActivity( Intent(this, HiTabBottomDemoActivity::class.java))
        }
    }


















}