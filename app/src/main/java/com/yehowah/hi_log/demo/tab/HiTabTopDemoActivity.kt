package com.yehowah.hi_log.demo.tab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.yehowah.hi_log.R
import com.yehowah.hiui.tab.bottom.HiTabBottomInfo
import com.yehowah.hiui.tab.top.HiTabTopInfo
import com.yehowah.hiui.tab.top.HiTabTopLayout


class HiTabTopDemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hi_tab_top_demo)
        initTabTop()
    }

    private val tabsStr = listOf<String>("热门", "服装", "数码","鞋子","零食","家电","化妆","日用","汽车","玩具","电子","科技")


    private fun initTabTop() {
        val hiTabTopLayout: HiTabTopLayout = findViewById(R.id.tab_top_layout)
        val infoList: MutableList<HiTabTopInfo<*>> = ArrayList()

        val defaultColor = resources.getColor(R.color.tabTopDefaultColor)
        val tintColor = resources.getColor(R.color.tabTopTintColor)
        for (s: String in tabsStr) {
            val info: HiTabTopInfo<*> = HiTabTopInfo(s, defaultColor, tintColor)
            infoList.add(info)
        }

        hiTabTopLayout.inflateInfo(infoList)
        hiTabTopLayout.addTabSelectedChangeListener { _,_,nextInfo ->
            Toast.makeText(this@HiTabTopDemoActivity, nextInfo.name, Toast.LENGTH_SHORT).show()
        }

        hiTabTopLayout.defaultSelected(infoList[0])
    }


}