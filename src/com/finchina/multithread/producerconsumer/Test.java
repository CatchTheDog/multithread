package com.finchina.multithread.producerconsumer;

public class Test {
    public static void main(String [] args){
        Person person = new Person();
        Producer producer = new Producer(person);
        Consumer consumer = new Consumer(person);
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        t1.start();
        t2.start();
    }
}
