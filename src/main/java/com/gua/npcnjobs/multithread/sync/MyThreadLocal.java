package com.gua.npcnjobs.multithread.sync;

public class MyThreadLocal {

    private static ThreadLocal<Integer> selfNumber = new ThreadLocal<>();
    private static ThreadLocal<String> selfString = new ThreadLocal<>();

    public static void main(String[] args) {
        String threadName = Thread.currentThread().getName();
        Thread thread01 = new Thread(new Task01());
        Thread thread02 = new Thread(new Task02());

        thread01.start();
        thread02.start();

        try {
            Thread.sleep(2L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(threadName+":selfNumber:"+selfNumber.get());
        System.out.println(threadName+":selfString:"+selfString.get());

    }


    private static class Task01 implements Runnable{

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName+":selfNumber:"+selfNumber.get());
            System.out.println(threadName+":selfString:"+selfString.get());

            selfNumber.set(3001);
            selfString.set("hello");

            System.out.println(threadName+":selfNumber:"+selfNumber.get());
            System.out.println(threadName+":selfString:"+selfString.get());
        }
    }

    private static class Task02 implements Runnable{

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName+":selfNumber:"+selfNumber.get());
            System.out.println(threadName+":selfString:"+selfString.get());

            selfNumber.set(6002);
            selfString.set("world");

            System.out.println(threadName+":selfNumber:"+selfNumber.get());
            System.out.println(threadName+":selfString:"+selfString.get());
        }
    }
}
