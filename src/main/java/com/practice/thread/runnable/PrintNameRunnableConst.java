package com.practice.thread.runnable;

public class PrintNameRunnableConst implements Runnable {
	
	Thread thread;
	   
	PrintNameRunnableConst(String name) {
        thread = new Thread(this, name);
        thread.start();
    }
	@Override
	public void run() {
		String name = thread.getName();
        for (int i = 0; i < 10; i++) {
            System.out.print(name);
        }
	}

}
