package com.practice.classinsideclass;

public class OuterClass {

    private String name = "R";
    private InnerClass innerClass = new InnerClass("");

    public   class InnerClass{
        public String l_name = "k";
        InnerClass(String l_name){
            name = "Ravi";
            this.l_name = l_name;

        }

        public String getL_name(){
         return "kumar";
        }



    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InnerClass getInnerClass() {
        return innerClass;
    }

    public void setInnerClass(InnerClass innerClass) {
        this.innerClass = innerClass;
    }
}




class Test{

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        System.out.println(outerClass.getInnerClass().getL_name());
    }
}
