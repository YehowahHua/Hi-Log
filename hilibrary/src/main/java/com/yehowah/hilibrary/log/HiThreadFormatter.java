package com.yehowah.hilibrary.log;

/**
 * created by cyh
 * on 2020/12/25 9:03
 * Description:
 **/
public class HiThreadFormatter implements HiLogFormatter<Thread> {
    @Override
    public String format(Thread data) {
        return "Thread:" + data.getName();
    }
}
