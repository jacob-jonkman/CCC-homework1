package com.company;

public class Consumer extends Thread {
    private SharedEntities sharedEntities;
    private int timeout;
    private String output = "";

    Consumer(int timeout, SharedEntities sharedEntities) {
        this.timeout = timeout;
        this.sharedEntities = sharedEntities;
    }

    public void run() {
        while(true) {
            try {
                sleep(timeout);
                sharedEntities.acquireRedBufferSemaphore();
                sharedEntities.acquireGreenBufferSemaphore();

                output = sharedEntities.consumerBuffer;
                System.out.println("Red   says " + output);

                output = sharedEntities.redBuffer;
                System.out.println("Green says " + output);

                sharedEntities.consumerBuffer = "";
                sharedEntities.redBuffer = "";
                sharedEntities.releaseGreenSemaphore();
                sharedEntities.releaseRedSemaphore();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}