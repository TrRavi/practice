package com.practice.thread.threadidentification;

import java.util.concurrent.TimeUnit;

public class MainClass {
	
	public static void main(String [] args) throws InterruptedException{
		
		boolean isContinue = false;
		while(!isContinue){
			System.out.println("Enter 1 for Printing Name");
			System.out.println("Enter 2 for Printing Name");
			
		}
		
		
		
		
		
		
		 PrintingThread pt= new PrintingThread();
		
		 getThreadObj(pt).start();
		    //Now, let's stop our Server thread
	        System.out.println(Thread.currentThread().getName() + " is stopping Server thread");
	       // TimeUnit.MILLISECONDS.sleep(200);
	       boolean isStop =  pt.stop();
	       if(isStop){
	    	   getThreadObj(pt).start(); 
	       }
	       TimeUnit.MILLISECONDS.sleep(200);
	        
	        //Let's wait to see server thread stopped 
	       
	        
	        System.out.println(Thread.currentThread().getName() + " is finished now");
	       
	}
	
	public static Thread getThreadObj(PrintingThread pt){
		Thread t1 = new Thread(pt, "T1");
		
		return t1;
	}
	
	

}
