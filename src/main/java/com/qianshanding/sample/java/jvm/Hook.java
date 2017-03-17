package com.qianshanding.sample.java.jvm;

/**
 * Created by fish on 2017/3/15.
 */
public class Hook implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " hook...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
