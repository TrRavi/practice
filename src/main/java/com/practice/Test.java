package com.practice;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.util.*;

public class Test {
    public Test() {
        super();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public static void main(String[] args) {



        IntergerListTry();
        MatecherStreamTry();
        StringListStreamTry();
        MapListStreamTry();

        sortMapByValue();


    }
  private static void changeStr(StringBuffer s){
        s = s.append("kbc");
  }

    private static void sortMapByValue() {
        Map<String,Integer>mapValue = new HashMap<>();
        Map<String,Integer>sortedMap = new HashMap<>();

        mapValue.put("key1",5);
        mapValue.put("key2",2);
        mapValue.put("key3",1);
        mapValue.entrySet().stream().
                sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x->{
                    sortedMap.put(x.getKey(),x.getValue());
                });

        sortedMap.entrySet().stream().forEach(stringStringEntry -> {
            System.out.println(stringStringEntry);
        });
    }

    private static void MatecherStreamTry() {
        List<Integer> lisofInt = Arrays.asList(3,4,3 );
        lisofInt.stream().forEach(System.out::print);

        boolean isPassed = lisofInt.stream().anyMatch(i -> i<2);
        System.out.println("lest dn 2 = "+isPassed);

        isPassed = lisofInt.stream().noneMatch(i -> i<2);
        System.out.println("none is less dn 2 = "+isPassed);

        isPassed = lisofInt.stream().allMatch(i -> i>2);
        System.out.println("all matches greater dn 2 = "+isPassed);
    }

    private static void MapListStreamTry() {
        List<Map<String,String>>listOfmap = new ArrayList<>();
        Map<String,String>mapValue = new HashMap<>();
        mapValue.put("key1","value1");
        mapValue.put("key2","value2");
        mapValue.put("key3","value3_1");
        listOfmap.add(mapValue);
        mapValue = new HashMap<>();
        mapValue.put("key1","value1");
        mapValue.put("key2","value2");
        mapValue.put("key3","value3_2");
        listOfmap.add(mapValue);
        mapValue = new HashMap<>();
        mapValue.put("key1","value1");
        mapValue.put("key2","value2");
        System.out.println(listOfmap);
        listOfmap.stream()
                .filter(x -> x.containsKey("key3"))
                .forEach(System.out::println);
    }

    private static void StringListStreamTry() {

        List<String>listOfStrings = Arrays.asList("Ravi","Kumar","Tr","T","r");
        listOfStrings.stream()
                .filter(s -> s.length() > 2)
                .map(s -> s.toUpperCase())
                .forEach(System.out::println);
    }

    private static void IntergerListTry() {
        List<Integer> lisofInt = Arrays.asList(3,4,3,1 );

        lisofInt.set(0, (int) Math.floor(4));

        int sum =  lisofInt.stream()
                .filter(integer -> {
                    return integer > 2;
                } )
                .map(integer -> integer*integer).mapToInt(y -> y).sum();
        System.out.println(sum);
    }


}
