package com.company;

public class Main {
    public static void main(String[] args) {
        SharedEntities sharedEntities = new SharedEntities();
        Consumer consumer = new Consumer(600, sharedEntities);
        GreenProducer greenProducer = new GreenProducer(400, sharedEntities);
        RedProducer redProducer = new RedProducer(500, sharedEntities);

        consumer.start();
        greenProducer.start();
        redProducer.start();
    }
}