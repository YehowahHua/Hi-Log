package com.yehowah.hilibrary.log;

/**
 * created by cyh
 * on 2020/12/23 10:14
 * Description:
 **/
public abstract class HiLogConfig {
    static int MAX_LEN = 512;//日志显示每一行最大字节数
    static HiThreadFormatter HI_THREAD_FORMATTER = new HiThreadFormatter();
    static HiStackTraceFormatter HI_STACK_TRACE_FORMATTER = new HiStackTraceFormatter();

    //Json序列化数据的注入
    public JsonParser injectJsonParser(){
        return null;
    }

    public String getGlobalTag(){
        return "HiLog";
    }

    //默认是启动的
    public boolean enable(){
        return true;
    }

    //默认日志不包含线程信息
    public boolean includeThread() {
        return false;
    }

    //堆栈信息的深度设定
    public int stackTraceDepth() {
        return 5;
    }

    //用户注册打印器
    public HiLogPrinter[] printers() {
        return null;
    }

    //解耦[不需要使用工具]，将序列号交给实现类进行解析
    public interface JsonParser{
        String toJson(Object src);
    }
}
