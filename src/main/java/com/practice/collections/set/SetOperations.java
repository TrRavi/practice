package com.practice.collections.set;


import java.util.*;
import java.util.stream.Collectors;

public class SetOperations {

    public static void main(String[] args) {

        /*HashMap<Employee,String> map = new HashMap<>();
        map.put(new Employee("A"),"EMp1");
        map.put(new Employee("B"),"EMp2");
        map.put(new Employee("A"),"EMp3");*/

       List<Employee> empList= new ArrayList<>();
       empList.add(new Employee("Ravi_1",25));
       empList.add(new Employee("Ravi_2",75));
       empList.add(new Employee("Ravi_3",56));
       empList.add(new Employee("Ravi_4",89));
       empList.add(new Employee("Ravi_5",36));
       empList.add(new Employee("Ravi_6",12));

       empList.forEach(employee -> {
           System.out.println(employee.getName()+" = "+employee.getAge());
       });

       /*empList.sort(new Comparator<Employee>() {
           @Override
           public int compare(Employee o1, Employee o2) {
               if(o1.getAge() == o2.getAge()){
                   return 0;
               }
               if(o1.getAge() > o2.getAge()){
                   return 1;
               }

               return -1;
           }
       });*/

        // using stream asc
       /* List<Employee> sortedempList = empList.stream()
                .sorted(Comparator.comparingInt(Employee::getAge))
                .collect(Collectors.toList());*/

        // using stream desc
        List<Employee> sortedempList = empList.stream()
                .sorted(Comparator.comparingInt(Employee::getAge).reversed())
                .collect(Collectors.toList());
        System.out.println("sorted");
        sortedempList.forEach(employee -> {
            System.out.println(employee.getName()+" = "+employee.getAge());
        });

    }


}
