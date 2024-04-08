package com.dailycoder.scalermock.util;


import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable{

    private CountDownLatch latch;

    public Processor(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    @SneakyThrows
    public void run() {
        System.out.println(Thread.currentThread()+"started");
        Thread.sleep(3000);
        latch.countDown();
    }
}

public class CountDownLatchUtil {

    @SneakyThrows
    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i=0;i<3;++i){
            executorService.submit(new Processor(countDownLatch));
        }

        countDownLatch.await();
        System.out.println("completed");
    }
}
