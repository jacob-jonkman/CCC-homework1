package com.company;

import java.util.concurrent.Semaphore;

public class SharedEntities {
    private final Semaphore bufferSemaphore = new Semaphore(1);
    public String redBuffer = "";
    public String greenBuffer = "";

    public void acquireBufferSemaphore() throws InterruptedException {
        bufferSemaphore.acquire();
    }
    public void releaseBufferSemaphore() {
        bufferSemaphore.release();
    }
}