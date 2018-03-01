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

                // Acquire buffer and perform dummy computation
                sharedEntities.acquireGreenSemaphore();
                sharedEntities.releaseGreenRunningSemaphore();

                // Wait until the other process is ready to write
                sharedEntities.acquireRedRunningSemaphore();

                sharedEntities.consumerBuffer = Integer.toString(number);

                sharedEntities.releaseGreenBufferSemaphore();

                number += 2;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
