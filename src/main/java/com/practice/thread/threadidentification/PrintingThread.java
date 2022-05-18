package com.practice.thread.threadidentification;

public class PrintingThread implements Runnable {
	
private volatile boolean exit = false;
    
    public void run() {
        while(!exit){
            System.out.println("PrintingThread is running.....");
        }
        
        System.out.println("Server is stopped....");
    }
    
    public boolean stop(){
        exit = true;
        return true;
    }

}
