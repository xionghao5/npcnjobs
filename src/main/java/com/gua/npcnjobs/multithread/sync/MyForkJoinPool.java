package com.gua.npcnjobs.multithread.sync;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class MyForkJoinPool {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Integer num = 4;

        ForkJoinTask<Integer> result = forkJoinPool.submit(new FacCalculator(num));

        try {
            System.out.println(num+"!="+result.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }

    private static class FacCalculator extends RecursiveTask<Integer>{
        private static final long serialVersionUID = 1L;

        private static final int THRESHOLD = 2;

        private int start;
        private int end;

        public FacCalculator(int end) {
            this.start =1;
            this.end = end;
        }

        public FacCalculator(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            String threadName = Thread.currentThread().getName();
            int result = 1;
            if((end-start)<THRESHOLD){
                for (int i = start; i <=end ; i++) {
                    result *=i;
                }

                System.out.println(threadName+":计算完成:"+start+"-"+end+"之间的乘积，结果为:"+result);
            }else {
                int middle = (start+end) >>>1;

                System.out.println(threadName+":将:"+start+"-"+end+"的任务拆分为:"+start+"-"+middle+"和"+(middle+1)+"-"+end+"两个子任务");

                FacCalculator left = new FacCalculator(start,middle);
                FacCalculator right = new FacCalculator(middle+1,end);

                left.fork();
                right.fork();

                result = left.join()* right.join();

                System.out.println(threadName+":将"+start+"-"+middle+"和"+(middle+1)+"-"+end+"两个子任务的结果合并,得到了"+start+"-"+end+"的乘积:"+result);

            }

            return result;
        }
    }
}
