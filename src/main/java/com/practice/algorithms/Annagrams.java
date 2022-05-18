package com.practice.algorithms;

import java.util.*;

public class Annagrams {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("abc","bac","def");
        Map<String,List<String>> output = new HashMap<>();
        for(int i = 0;i<stringList.size();i++){
            String sortedString = sortString(stringList.get(i));
            if(output.containsKey(sortedString)){
                List<String> annaList = output.get(sortedString);
                annaList.add(stringList.get(i));
            }else{
                List<String> annaList = new ArrayList<>();
                annaList.add(stringList.get(i));
                output.put(sortedString,annaList);
            }
        }

        output.forEach((s, strings) ->{
            System.out.println( strings);
        });

    }

    private static String sortString(String s) {
        char [] tempArr = s.toCharArray();
        Arrays.sort(tempArr);
        return  new String(tempArr);
    }
}
