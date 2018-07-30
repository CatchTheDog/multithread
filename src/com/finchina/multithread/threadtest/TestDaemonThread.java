package com.finchina.multithread.threadtest;

/**
 * 守护线程
 */
public class TestDaemonThread {
    public static void main(String[] args) {
        System.out.println("start main!");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        System.out.println("end main");
    }
}
