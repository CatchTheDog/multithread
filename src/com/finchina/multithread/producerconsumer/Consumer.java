package com.finchina.multithread.producerconsumer;

public class Consumer implements Runnable {

    Person person = null;

    public Consumer(Person person) {
        this.person = person;
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
       for(int i = 0;i<50;i++){
           person.pop();
       }
    }
}
