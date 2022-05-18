package com.practice.algorithms;

public class Palindrome {

    public static void main(String[] args) {
        String s = "abab";

        char[] charaArr =  s.toCharArray();
        for(int i=0;i<s.length();i++){
            for(int j = i+1;j <= s.length();j++){
                boolean ispalindrome = checkPalindrome(s.substring(i,j));
                if(ispalindrome && s.substring(i,j).length()>=2){
                    System.out.println(s.substring(i, j));
                }
            }
        }
    }

    private static boolean checkPalindrome(String substring) {
        StringBuilder s1 = new StringBuilder(substring);
        StringBuilder reverse = s1.reverse();
        return reverse.toString().equals(substring);
    }
}
