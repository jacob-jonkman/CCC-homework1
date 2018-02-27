package com.company;

import java.util.concurrent.Semaphore;

public class SharedEntities {
    private final Semaphore bufferSemaphore = new Semaphore(1);
    private final Semaphore redSemaphore = new Semaphore(0);
    private final Semaphore greenSemaphore = new Semaphore(1);
    private final Semaphore brownSemaphore = new Semaphore(0);

    public String buffer = "";

    public void acquireBufferSemaphore() throws InterruptedException {
        bufferSemaphore.acquire();
    }
    public void releaseBufferSemaphore() {
        bufferSemaphore.release();
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

    public void acquireBrownSemaphore() throws InterruptedException {
        brownSemaphore.acquire();
    }
    public void releaseBrownSemaphore() {
        brownSemaphore.release();
    }
}