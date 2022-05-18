package com.practice.thread.nonsynchronization;

public class TwoString {
	
	
	//for non synchronized 
	/*static void print(String str1,String str2){
		 System.out.print(str1);
	        try {
	            Thread.sleep(500);
	        }catch (InterruptedException ie) {
	        	System.out.println("Exception e = "+ie.getMessage());
	        }
	        System.out.println(str2);
		
	}*/
	
	
	
	//for synchronized  
	synchronized  static void print(String str1,String str2){
		 System.out.print(str1);
	        try {
	            Thread.sleep(500);
	        }catch (InterruptedException ie) {
	        	System.out.println("Exception e = "+ie.getMessage());
	        }
	        System.out.println(str2);
		
	}

}
