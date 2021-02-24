package com.yehowah.hilibrary.log;

import org.jetbrains.annotations.NotNull;

/**
 * created by cyh
 * on 2020/12/25 8:58
 * Description:
 **/
public interface HiLogPrinter {
    void print(@NotNull HiLogConfig config, int level, String tag, @NotNull String printString);
}
