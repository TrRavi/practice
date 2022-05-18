package com.practice.collections.map;

import java.util.HashMap;

public class HashMapWorking {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        map.put("d",4);
        map.put("d",8);

        System.out.println(map);
    }
}
