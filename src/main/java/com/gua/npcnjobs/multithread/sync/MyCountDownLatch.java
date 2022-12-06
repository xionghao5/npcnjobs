package com.gua.npcnjobs.multithread.sync;

import java.util.concurrent.CountDownLatch;

public class MyCountDownLatch {


    private static CountDownLatch countDownLatch = new CountDownLatch(5);

    public static void main(String[] args) {
        Thread postTaskThread = new Thread(new PostTask());

        postTaskThread.start();

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Task());
            thread.start();
        }
    }

    private static class Task implements Runnable {

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();

            System.out.println(threadName + "开始执行");

            try {
                Thread.sleep((long) (Math.random() * 100));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            countDownLatch.countDown();

            System.out.println(threadName + "结束任务");
        }
    }

    private static class PostTask implements Runnable {

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(threadName + "唤醒了");
        }
    }
}
