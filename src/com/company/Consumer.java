package com.company;

public class Consumer extends Thread {
    private SharedEntities sharedEntities;
    private int timeout;
    private int number = 0;

    Consumer(int timeout, SharedEntities sharedEntities) {
        this.timeout = timeout;
        this.sharedEntities = sharedEntities;
    }

    public void run() {
        while(true) {
            try {
                sleep(timeout);
                sharedEntities.acquireBufferSemaphore();
                if(!sharedEntities.buffer.equals("")) {
                    number = Integer.parseInt(sharedEntities.buffer);
                    if(number < 0) {
                        System.out.println("Brown says " + number);
                    }
                    else if(number % 2 == 0) {
                        System.out.println("Red   says " + number);
                    }
                    else {
                        System.out.println("Green says " + number);
                    }
                    sharedEntities.buffer = "";
                }
                sharedEntities.releaseBufferSemaphore();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}