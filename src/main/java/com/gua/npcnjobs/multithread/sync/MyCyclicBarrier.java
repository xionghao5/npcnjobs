package com.gua.npcnjobs.multithread.sync;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyCyclicBarrier {

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(4, new Action());

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {

            Thread thread = new Thread(new Task());

            thread.start();
        }
    }


    private static class Task implements Runnable {

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            try {
                Thread.sleep((long) (Math.random() * 1000));

                System.out.println(threadName + ":完成第一阶段任务");

                System.out.println(threadName + "到达栅栏，倒计数:" + cyclicBarrier.await());

                System.out.println(threadName+":进入第二阶段工作");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }


    private static class Action implements Runnable {

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + ":执行额外任务");
        }
    }


}
