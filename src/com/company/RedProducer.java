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

                // Acquire buffer and perform dummy computation
                sharedEntities.acquireRedSemaphore();
                sharedEntities.releaseRedRunningSemaphore();

                // Wait until the other process is ready to write
                sharedEntities.acquireGreenRunningSemaphore();

                sharedEntities.redBuffer = Integer.toString(number);

                sharedEntities.releaseRedBufferSemaphore();

                number += 2;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
