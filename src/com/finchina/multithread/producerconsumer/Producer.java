package com.finchina.multithread.producerconsumer;

/**
 * 生产者
 */
public class Producer implements Runnable {

    Person person = null;

    public Producer(Person person) {
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
           if(i%2 == 0){
               person.push("Tom",11);
           }else{
               person.push("Marry",21);
           }

       }
    }
}
