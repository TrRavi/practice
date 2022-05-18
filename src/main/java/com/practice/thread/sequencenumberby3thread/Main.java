package com.practice.thread.sequencenumberby3thread;

public class Main {

    public static void main(String[] args) {

        PrintThread p1=new PrintThread(1);
        PrintThread p2=new PrintThread(2);
        PrintThread p3=new PrintThread(0);

        Thread t1=new Thread(p1,"T1");
        Thread t2=new Thread(p2,"T2");
        Thread t3=new Thread(p3,"T3");

        t1.start();
        t2.start();
        t3.start();
    }
}


