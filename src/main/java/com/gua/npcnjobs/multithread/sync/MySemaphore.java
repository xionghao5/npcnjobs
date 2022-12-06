package com.gua.npcnjobs.multithread.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class MySemaphore {

    private static Semaphore semaphore = new Semaphore(0);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new RunDemo(2,1));
        executorService.execute(new RunDemo(1,1));
        executorService.execute(new RunDemo(2,1));
        executorService.execute(new RunDemo(1,1));
        executorService.execute(new RunDemo(0,1));
        executorService.shutdown();
    }

    private static class RunDemo implements Runnable {
        private Integer inputCount;
        private Integer outputCount;

        public RunDemo(Integer inputCount, Integer outputCount) {
            this.inputCount = inputCount;
            this.outputCount = outputCount;
        }


        @Override
        public void run() {

            try {
                String threadName = Thread.currentThread().getName();
                semaphore.acquire(inputCount);
                System.out.println(threadName + "获取" + inputCount + "个许可开始工作。。。");
                Thread.sleep((long) (Math.random() * 100));

                System.out.println(threadName+"====完成工作释放"+outputCount+"个工作许可，当前共有"+(semaphore.availablePermits()+outputCount)+"个可以给出的许可");

                semaphore.release(outputCount);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }
}
