package com.company;

public class Main {
    public static void main(String[] args) {
        SharedEntities sharedEntities = new SharedEntities();
        Consumer consumer = new Consumer(400, sharedEntities);
        GreenProducer greenProducer = new GreenProducer(500, sharedEntities);
        RedProducer redProducer = new RedProducer(300, sharedEntities);

        //TEST//
        consumer.start();
        greenProducer.start();
        redProducer.start();
    }
}