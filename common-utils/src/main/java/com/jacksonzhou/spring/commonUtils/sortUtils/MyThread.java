package com.jacksonzhou.spring.commonUtils.sortUtils;

public class MyThread {

    static class MyThread1 implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i <10; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("===T1===");
            }
        }
    }

    static class MyThread2 extends Thread {

        @Override
        public void run(){
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("===T2===");
            }
        }
    }

    public static void mm(){
        synchronized (MyThread.class){

        }
    }

    public static void main(String[] args) {
        new MyThread2().start();
        new Thread(new MyThread1()).start();
    }
}
