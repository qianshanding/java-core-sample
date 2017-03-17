package com.qianshanding.sample.java.mxbean;

import java.lang.management.ManagementFactory;

/**
 * 通过MXBean获取当前系统的pid
 * Created by fish on 2017/3/15.
 */
public class ProcessPidSample {
    public static void main(String[] args) {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String[] split = name.split("@");
        if (split.length != 2) {
            throw new RuntimeException("Got unexpected process name: " + name);
        }
        System.out.println(name);
        System.out.println(split[0]);
    }
}
