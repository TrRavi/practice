package com.practice.thread.threadpriority;

public class TestThread extends Thread {
	public TestThread(String str) {
        super(str);
    }
   
    public void run() {
        for (int i = 0; i < 5; i++) {
             System.out.println("counter = "+i+" Thread = "+getName()+"  Priority = "+getPriority());
            /*try {
                sleep((long)(Math.random() * 1000));
            } catch (InterruptedException e) {}*/
        }
        System.out.format("DONE! %s%n", getName());
    }
}
