package com.practice.oops.polymorphism;
class Derived
{
     public   void walk ()   {
        System.out.println("Walk in derived");
    }

    public void run(){
        System.out.println("run in derived");
        //walk();
    }
}

public class Test extends Derived
{
       public void walk () throws NumberFormatException  {
        System.out.println("Walk in Test");
       // super.walk();
    }
    public void run()
    {
        System.out.println("run in test class");
        super.run();

    }
    public static void main(String[] args)
    {
        Derived obj = new Test();  // line xyz
      //  Derived obj1 = new Derived();  // line xyz
        obj.walk();
       // obj1.getDetails();
    }
}