package com.company;

public class GreenProducer extends Thread {
    private SharedEntities sharedEntities;
    private int timeout;
    private int number = 1001;

    GreenProducer(int timeout, SharedEntities sharedEntities) {
        this.timeout = timeout;
        this.sharedEntities = sharedEntities;
    }

    public void run() {
        while(true) {
            try {
                sleep(timeout);
                sharedEntities.acquireGreenSemaphore();

                while(!sharedEntities.buffer.equals(""))
                    sleep(timeout/5);

                sharedEntities.acquireBufferSemaphore();
                sharedEntities.buffer = Integer.toString(number);
                sharedEntities.releaseBufferSemaphore();
                sharedEntities.releaseRedSemaphore();

                number += 2;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
