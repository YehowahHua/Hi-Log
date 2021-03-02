package com.yehowah.hilibrary.log;

/**
 * created by cyh
 * on 2020/12/25 9:06
 * Description:
 **/
public class HiStackTraceFormatter implements HiLogFormatter<StackTraceElement[]> {
    @Override
    public String format(StackTraceElement[] stackTrace) {
        StringBuilder sb = new StringBuilder(128);
        if (stackTrace == null || stackTrace.length == 0) {
            return null;
        } else if (stackTrace.length == 1) {
            return "\t- " + stackTrace[0].toString();
        } else {
            for (int i = 0, len = stackTrace.length; i < len; i++) {
                if (i == 0) {
                    sb.append("stackTrace: \n");//
                }
                if (i != len - 1) {
                    sb.append("\t├ ");
                    sb.append(stackTrace[i].toString());//添加堆栈信息
                    sb.append("\n");
                } else {
                    sb.append("\t┕ ");
                    sb.append(stackTrace[i].toString());
                }
            }
            return sb.toString();
        }
    }
}
