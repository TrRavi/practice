package com.practice.thread.nonsynchronization;

public class PrintThread implements Runnable {
	
	Thread thread;
	
	String str1,str2;
	
	public  PrintThread(String str1,String str2){
		this.str1 = str1;
		this.str2 = str2;
		thread = new Thread(this);
		thread.start();
		
	}
	@Override
	public void run() {
		TwoString.print(str1, str2);
		
	}
	

}
