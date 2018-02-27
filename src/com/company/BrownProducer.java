package com.company;

public class BrownProducer extends Thread {
    private SharedEntities sharedEntities;
    private int timeout;
    private int number = -3003;

    BrownProducer(int timeout, SharedEntities sharedEntities) {
        this.timeout = timeout;
        this.sharedEntities = sharedEntities;
    }

    public void run() {
        while(true) {
            try {
                sleep(timeout);
                sharedEntities.acquireBrownSemaphore();

                while(!sharedEntities.buffer.equals(""))
                    sleep(timeout/5);

                sharedEntities.acquireBufferSemaphore();
                sharedEntities.buffer = Integer.toString(number);
                sharedEntities.releaseBufferSemaphore();
                sharedEntities.releaseGreenSemaphore();

                number -= 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
