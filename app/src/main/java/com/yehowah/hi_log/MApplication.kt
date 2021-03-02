package com.yehowah.hi_log

import android.app.Application
import com.google.gson.Gson
import com.yehowah.hilibrary.log.HiConsolePrinter
import com.yehowah.hilibrary.log.HiLogConfig
import com.yehowah.hilibrary.log.HiLogManager

/**
 * created by cyh
 * on 2020/12/24 15:40
 * Description:
 **/
class MApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        HiLogManager.init(object : HiLogConfig() {
            override fun injectJsonParser(): JsonParser {
                return JsonParser { src -> Gson().toJson(src) }
            }

            override fun getGlobalTag(): String {
                return "MApplication"
            }

            override fun enable(): Boolean {
                return true
            }
        }, HiConsolePrinter())//传入打印器
    }
}