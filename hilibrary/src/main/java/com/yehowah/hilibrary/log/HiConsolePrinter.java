package com.yehowah.hilibrary.log;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import static com.yehowah.hilibrary.log.HiLogConfig.MAX_LEN;

/**
 * created by cyh
 * on 2020/12/25 9:15
 * Description: 控制台打印器
 **/
public class HiConsolePrinter implements HiLogPrinter {
    @Override
    public void print(@NotNull HiLogConfig config, int level, String tag, @NotNull String printString) {
        int len = printString.length();
        int countOfSub = len / MAX_LEN;
        //行数
        if (countOfSub > 0) {
            int index = 0;
            for (int i = 0; i < countOfSub; i++) {
                Log.println(level, tag, printString.substring(index, index + MAX_LEN));
                index += MAX_LEN;
            }
            //不能被整除，将剩余打印出来
            if (index != len) {
                Log.println(level, tag, printString.substring(index, len));
            }
        } else {
            Log.println(level, tag, printString);//不满足1行
        }

    }
}
