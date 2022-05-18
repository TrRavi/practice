package com.practice.thread.nonsynchronization;

public class MainClass {
	
	public static void main(String [] agrs){
		
		new PrintThread("Hello ", "there.");
        new PrintThread("How are ", "you?");
        new PrintThread("Thank you ", "very much!");
		
	}

}
