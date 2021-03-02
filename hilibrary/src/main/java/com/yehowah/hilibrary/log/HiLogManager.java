package com.yehowah.hilibrary.log;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by cyh
 * on 2020/12/23 10:16
 * Description:
 **/
public class HiLogManager {
    //实现单例
    private HiLogConfig config;

    private static HiLogManager instance;

    public static HiLogManager getInstance() {
        return instance;
    }


    //数组保存打印器
    private List<HiLogPrinter> printers = new ArrayList<>();


    private HiLogManager(HiLogConfig config, HiLogPrinter[] printers) {
        this.config = config;
        this.printers.addAll(Arrays.asList(printers));//数组-->ArrayList
    }


    //初始化
    public static void init(@NonNull HiLogConfig config, HiLogPrinter... printers) {
//        Log.i("TAG", "init: printers--"+printers);
        instance = new HiLogManager(config, printers);
    }

    public HiLogConfig getConfig() {
        return config;
    }

    public List<HiLogPrinter> getPrinters() {
        return printers;
    }

    //手动添加打印器
    public void addPrinter(HiLogPrinter printer){
        printers.add(printer);
    }

    public void removePrinter(HiLogPrinter printer){
        if (printers != null){
            printers.remove(printer);
        }
    }





}
