package com.qianshanding.sample.java.jvm;

/**
 * System.exit(-1) 和 Runtime.getRuntime().halt(-1)的区别
 * Created by fish on 2017/3/15.
 */
public class SystemExitAndRuntimeHaltSample {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new Hook());
            Runtime.getRuntime().addShutdownHook(t);
        }
        /**
         * 终止当前正在运行的Java虚拟机。参数作为状态代码,按照惯例,一个非零状态码表示异常终止。
         * 用线程描述，在多线程情况下，可能更准确一些
         * 1.调用方法后，线程会退出
         * 2.未捕获的异常被线程抛出,但如果有其他非守护线程,程序将继续运行。
         * 3.反馈状态码，一般在脚本中有用。
         * 4.线程退出，还是做一些清理动作
         *
         * Java虚拟机退出包括两个阶段：
         * 第一个阶段：会以某种未指定的顺序启动所有已注册钩子，并且允许它们同时运行直至结束
         * 第二个阶段：如果已启用runFinalizersOnExit设置为true，则运行所有未调用的终结方法（finalizer方法）
         */
        System.exit(-1);
        /**
         * 不会执行钩子函数和finalizer方法，而是直接退出
         */
//        Runtime.getRuntime().halt(-1);
    }
}

