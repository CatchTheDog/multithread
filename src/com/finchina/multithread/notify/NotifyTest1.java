package com.finchina.multithread.notify;

/**
 * 被wait的线程，在满足如下两个条件的情况下才会继续运行：
 * 1.由其他线程notify或notifyall,并且当前线程被通知到了
 * 2.经过和其他线程进行锁竞争，成功拿到锁
 * <p>
 * notify与notifyall相比，都能使等待状态的线程被唤醒（最终都只有一个线程获得锁运行），但是notifyall会唤醒所有等待线程，后续不需要再次唤醒；
 * 而notify需要再次唤醒其他未唤醒线程。
 */
public class NotifyTest1 {
    private static final Object OBJECT = new Object();

    private static class R implements Runnable {

        private int i;

        R(int i) {
            this.i = i;
        }

        public static void main(String[] args) throws InterruptedException {
            Thread[] rs = new Thread[10];
            for (int i = 0; i < rs.length; i++) {
                rs[i] = new Thread(new R(i));
            }
            for (Thread r : rs) {
                r.start();
            }
            Thread.sleep(5000);
            synchronized (OBJECT) {
                OBJECT.notifyAll();
            }
        }

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {
            try {
                synchronized (OBJECT) {
                    System.out.println("线程->" + i + "等待中");
                    OBJECT.wait();
                    System.out.println("线程->" + i + "在运行了");
                    Thread.sleep(30000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
