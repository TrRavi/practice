package com.practice.thread.threadpriority;


public class MainClass {
	 public static void main (String[] args) {
		Thread t1 =  new TestThread("A");
		t1.start();
		t1.setPriority(1);
		Thread t2 =  new TestThread("B");
		t2.start();
		t2.setPriority(5);
		Thread t3 = new TestThread("C");
		t3.start();
		t3.setPriority(10);
		 
		 
	 }

}
