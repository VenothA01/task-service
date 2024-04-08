package com.dailycoder.scalermock.util;

import lombok.SneakyThrows;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {


    private static Random random = new Random();

    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    @SneakyThrows
    public static void produce(){
        while (true){
            queue.put(random.nextInt(100));
        }
    }

    @SneakyThrows
    public static void consume(){

        while (true){
            Thread.sleep(100);
            if(random.nextInt(10)==10){
                var value = queue.take();
                System.out.println(String.format("taken value is %d and q size is %d",value,queue.size()));
            }
        }

    }

    @SneakyThrows
    public static void main(String[] args) {

        Thread producerThread = new Thread(ProducerConsumer::produce);
        Thread consunmerThread = new Thread(ProducerConsumer::consume);

        producerThread.start();
        consunmerThread.start();

        producerThread.join();
        consunmerThread.join();
    }
}
