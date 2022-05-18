package com.practice.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class KthLargestNumber {

    public static void main(String[] args) {
        int kthNumber = 3;
        // for a infinite stream of number we can take CopyOnWriteArrayList.
        CopyOnWriteArrayList<Integer> nums = new CopyOnWriteArrayList<>();
        nums.add(98);
        nums.add(1);
        nums.add(6);
        nums.add(5);
        nums.add(5);
        nums.add(4);
        nums.add(9);

        //for getting kth largest number we will have to sort the list
        // and remove duplicate element from list
        // for this purpose we can use stream feature of java 8. it works parallel so its faster...
        List<Integer> sortedList = nums.stream().sorted().distinct().collect(Collectors.toList());

        // we have to check if there is kth element in lst or not.. mean list size must be > kth number
        if( kthNumber > sortedList.size()){
            System.out.println("There is no kth element");
        }else{
            int kthIndex = kthNumber-1;// index start from 0
            System.out.println("kth largest Number is = " + sortedList.get(kthIndex));
        }

    }

    public static class AncestorTracker {
        private final Map<String, List<String>> childToParentMappings = new HashMap<String, List<String>>();

        public void addChildParentMapping(String child, String parent) {
            List<String> existingParents = childToParentMappings.get(child);
            if (existingParents == null) {
                existingParents = new ArrayList<String>();
                childToParentMappings.put(child, existingParents);
            }
            if (!existingParents.contains(parent)) {
                existingParents.add(parent);
            }
        }

        public boolean isAncestor(String child, String ancestor) {
            boolean result = false;

            if (childToParentMappings.containsKey(child)) {
                List<String> immedidateParents = childToParentMappings.get(child);
                if (immedidateParents.contains(ancestor)) {
                    result = true;
                } else {
                    for (String immediateParent : immedidateParents) {
                        if (isAncestor(child, immediateParent)) {
                            result = true;
                            break;
                        }
                    }
                }
            }

            return result;
        }

        public static void main(String[] args) {
            AncestorTracker ancestorTracker = new AncestorTracker();
            String[][] pairs = { {"x", "y"}, {"a", "b"}, {"b", "x"}};

            for (String[] aPair : pairs) {
                String child = aPair[1];
                String parent = aPair[0];

                if (ancestorTracker.isAncestor(child, parent)) {
                    System.out.println(child + " is already a decendent of " + parent);
                } else {
                    ancestorTracker.addChildParentMapping(child, parent);
                }
            }

            System.out.println(ancestorTracker.childToParentMappings);
        }
    }
}
