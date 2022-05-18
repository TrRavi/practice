package com.practice.onlinetest;

class A{
    int i =5;
}
class B extends A{
    int i = 10;
}
public class T1 {

    public static void throwit(){
        System.out.println("throwit");
        throw new RuntimeException();
    }

    public static void main(String[] args) {
       //Thread x = Thread.currentThread();
        //System.out.println(x.getPriority());
        B a = new B();
        System.out.println(a.i);

        /*try{
            System.out.println("hello");
            throwit();
        }catch (Exception e){
            System.out.println("caugth");
        }finally {
            System.out.println("finally");
        }
        System.out.println("after");*/
    }
}
