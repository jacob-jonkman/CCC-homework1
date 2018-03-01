package com.company;

import java.util.concurrent.Semaphore;

public class SharedEntities {
    private final Semaphore redBufferSemaphore = new Semaphore(0);
    private final Semaphore greenBufferSemaphore = new Semaphore(0);
    private final Semaphore redSemaphore = new Semaphore(1);
    private final Semaphore greenSemaphore = new Semaphore(1);
    private final Semaphore redRunningSemaphore = new Semaphore(0);
    private final Semaphore greenRunningSemaphore = new Semaphore(0);

    public String consumerBuffer = "";
    public String redBuffer = "";

    public void acquireGreenBufferSemaphore() throws InterruptedException {
        greenBufferSemaphore.acquire();
    }
    public void releaseGreenBufferSemaphore() {
        greenBufferSemaphore.release();
    }

    public void acquireRedBufferSemaphore() throws InterruptedException {
        redBufferSemaphore.acquire();
    }
    public void releaseRedBufferSemaphore() {
        redBufferSemaphore.release();
    }

    public void acquireRedSemaphore() throws InterruptedException {
        redSemaphore.acquire();
    }
    public void releaseRedSemaphore() {
        redSemaphore.release();
    }

    public void acquireGreenSemaphore() throws InterruptedException {
        greenSemaphore.acquire();
    }
    public void releaseGreenSemaphore() {
        greenSemaphore.release();
    }

    public void acquireRedRunningSemaphore() throws InterruptedException {
        redRunningSemaphore.acquire();
    }
    public void releaseRedRunningSemaphore() {
        redRunningSemaphore.release();
    }

    public void acquireGreenRunningSemaphore() throws InterruptedException {
        greenRunningSemaphore.acquire();
    }
    public void releaseGreenRunningSemaphore() {
        greenRunningSemaphore.release();
    }
}