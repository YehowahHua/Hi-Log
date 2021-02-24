package com.yehowah.hilibrary.log;

/**
 * created by cyh
 * on 2020/12/25 9:01
 * Description:
 **/
public interface HiLogFormatter<T> {
    String format(T data);
}
