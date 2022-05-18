package com.practice.designpattern.singletion;

public class Singleton {

    int a,a1;

    static Singleton singleton = null;

    private Singleton(){

    }


    public static synchronized Singleton getObjectOfSingleton(){
        if(singleton == null){
            singleton = new Singleton();

        }
        return singleton;

    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getA1() {
        return a1;
    }

    public void setA1(int a1) {
        this.a1 = a1;
    }
}
