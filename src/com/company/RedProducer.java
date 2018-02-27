package com.company;

public class RedProducer extends Thread {
    private SharedEntities sharedEntities;
    private int timeout;
    private int number = 2002;

    RedProducer(int timeout, SharedEntities sharedEntities) {
        this.timeout = timeout;
        this.sharedEntities = sharedEntities;
    }

    public void run() {
        while(true) {
            try {
                sleep(timeout);
                sharedEntities.acquireRedSemaphore();

                while(!sharedEntities.buffer.equals(""))
                    sleep(timeout/5);

                sharedEntities.acquireBufferSemaphore();
                sharedEntities.buffer = Integer.toString(number);
                sharedEntities.releaseBufferSemaphore();
                sharedEntities.releaseGreenSemaphore();

                number += 2;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
