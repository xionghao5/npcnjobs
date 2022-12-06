package com.gua.npcnjobs.multithread;

public class MyRunable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }


    public static void main(String[] args) {

        Thread thread = new Thread(new MyRunable());

        thread.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }

    }
}
