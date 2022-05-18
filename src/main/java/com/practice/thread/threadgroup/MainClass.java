package com.practice.thread.threadgroup;

public class MainClass {
	
	 public static void main (String[] args) {
		 new TestThread("A").start();
		 new TestThread("B").start();
		 new TestThread("C").start();
		 
		 ThreadGroup group = Thread.currentThread().getThreadGroup();
	        System.out.println("Number of active threads in this thread group = "
	                            + group.activeCount());
	       
	        // Display the names of the threads in the current
	        // ThreadGroup.
	        Thread[] tarray = new Thread[10];
	        int actualSize = group.enumerate(tarray);
	        for (int i=0; i<actualSize;i++){
	            System.out.println("Thread " + tarray[i].getName()
	                               + " in thread group " + group.getName());
	        }
	 }
}
