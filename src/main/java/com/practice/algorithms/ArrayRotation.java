package com.practice.algorithms;

/*
Write a program to  rotate(ar[], d, n) that rotates arr[] of size n by d elements.
        Input: [1, 2, 3, 4, 5, 6, 7]  d=3, n=7
        Output : [4, 5, 6, 7, 1, 2,3]
*/

public class ArrayRotation {

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5, 6, 7};
        int d = 3;
        int size = arr.length;

        int [] temp = new int[d];
        for(int i =0;i<d;i++){
           temp[i] = arr[i];
        }

        for( int i=d ;i<size;i++){
            arr[i-d] = arr[i];
        }

        for(int i=0;i<d;i++){
            arr[i+size-d] = temp[i];
        }

        for (int i : arr) {
            System.out.print(i+" , ");
        }
        
    }

}
