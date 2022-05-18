package com.practice.algorithms.pattern;

public class First {


    public static void main(String args[]) //driver function
    {
        int n = 5;
        for (int i=1; i<=n; i++)
        {
            for (int j=1; j<=i; j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
