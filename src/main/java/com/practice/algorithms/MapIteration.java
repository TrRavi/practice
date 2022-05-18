package com.practice.algorithms;

import java.util.*;

public class MapIteration {
    public static void main(String[] args) {
        System.out.println("Map loop example");
        System.out.println();

        /** creating a new Map object */
        Map<String, String> map = new HashMap<String, String>();

        /** adding some values */
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        map.put("key5", "value5");

        /** using while and interator method */
        System.out.println("Method 1: ");
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator.next();
            System.out.println(entry.getKey() + " ==> " + entry.getValue());
        }
        System.out.println();

        /** using for and keySet to get the keys and values */
        System.out.println("Method 2:");
        for (Object key : map.keySet()) {
            System.out.println(key.toString() + " ==> " + map.get(key));
        }
        System.out.println();

        /** using for and entrySet method */
        System.out.println("Method 3: ");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " ==>" + entry.getValue());
        }
        System.out.println();

        /** using Java 8, forEach and Lambda */
        System.out.println("Method 4:");
        map.forEach((k, v) -> System.out.println(k + " ==> " + v));
        System.out.println();

        System.out.println("Method 5:");
        Set<String> set = map.keySet();
        Iterator<String> keys = set.iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            System.out.println(key + " ==> " + map.get(key));
        }
        System.out.println();

        System.out.println("Method 6: ");
        Collection<String> valuesC = map.values();
        Iterator<String> values = valuesC.iterator();
        while (values.hasNext()) {
            String value = values.next();
            System.out.println(value);
        }
    }

    public static class ExcelColumnTitle {
        private static void printString(int columnNumber) {
            StringBuilder columnName = new StringBuilder();
            while (columnNumber > 0) {
                int rem = columnNumber % 26;
                if (rem == 0) {
                    columnName.append("Z");
                    columnNumber = (columnNumber / 26) - 1;
                } else // If remainder is non-zero
                {
                    columnName.append((char) ((rem - 1) + 'A'));
                    columnNumber = columnNumber / 26;
                }
            }

            System.out.println(columnName.reverse());
        }
        public static void main(String[] args) {
            printString(26);
            printString(51);
            printString(52);
            printString(80);
            printString(676);
            printString(702);
            printString(705);
        }
    }
}
