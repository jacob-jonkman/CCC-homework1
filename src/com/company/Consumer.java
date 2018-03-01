package com.company;

public class Consumer extends Thread {
    private SharedEntities sharedEntities;
    private int timeout;
    private int number = 0;
    private Boolean redTurn = false;

    Consumer(int timeout, SharedEntities sharedEntities) {
        this.timeout = timeout;
        this.sharedEntities = sharedEntities;
    }

    public void run() {
        while(true) {
            try {
                sleep(timeout);
                sharedEntities.acquireBufferSemaphore();
                if(!sharedEntities.redBuffer.equals("") && redTurn == true) {
                    number = Integer.parseInt(sharedEntities.redBuffer);
                    System.out.println("Red   says " + number);
                    sharedEntities.redBuffer = "";
                    redTurn = false;
                }
                else if(!sharedEntities.greenBuffer.equals("") && redTurn == false) {
                    number = Integer.parseInt(sharedEntities.greenBuffer);
                    System.out.println("Green says " + number);
                    sharedEntities.greenBuffer = "";
                    redTurn = true;
                }

                sharedEntities.releaseBufferSemaphore();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}