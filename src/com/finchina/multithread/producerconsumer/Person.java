package com.finchina.multithread.producerconsumer;

public class Person {
    private String name;
    private int age;
     //表示是否需要生产共享资源对象，如果为true,表示需要生产;如果为false,则不需要生产
    private boolean isEmpty = true;

    /**
     * 生产数据
     */
    public synchronized void push(String name,int age){
        try {
            while(!isEmpty){
                this.wait();
            }
            this.age = age;
            Thread.sleep(10);
            this.name = name;
            isEmpty = false;
            this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * 消费数据
     */
    public synchronized void pop(){
        try {
            while(isEmpty){
                this.wait();
            }
            Thread.sleep(10);
            System.out.println(this.name + "---" + this.age);
            isEmpty = true;
            this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
