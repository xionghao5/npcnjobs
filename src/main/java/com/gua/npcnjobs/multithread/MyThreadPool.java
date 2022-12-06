package com.gua.npcnjobs.multithread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future fR= executorService.submit(new MyRunable());
        Future fC = executorService.submit(new CTask());
        executorService.shutdown();
        try {
            System.out.println(fR.get());
            System.out.println(fC.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
