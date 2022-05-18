package com.practice.vanhack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ChefSchedulerTest {

    public static void main(String[] args) {
        itShouldWorkOnBasicExamples();
    }

    public static void itShouldWorkOnBasicExamples() {
        HashMap<String, ArrayList<String>> requests = new HashMap<>();
        requests.put("ada", new ArrayList<>(Arrays.asList(new String[]{"mon", "tue", "wed", "fri", "sat", "sun"})));
        requests.put("emma", new ArrayList<>(Arrays.asList(new String[]{"tue", "wed", "thu", "sun"})));
        requests.put("remy", new ArrayList<>(Arrays.asList(new String[]{"mon", "sat"})));
        requests.put("zach", new ArrayList<>(Arrays.asList(new String[]{})));


        if (ChefScheduler.schedulable(requests) == true) {
            System.out.println("it should work on a basic example.");
        }

        requests.clear();
        requests.put("emma", new ArrayList<>(Arrays.asList(new String[]{"sun"})));
        requests.put("remy", new ArrayList<>(Arrays.asList(new String[]{"sun"})));
        requests.put("zach", new ArrayList<>(Arrays.asList(new String[]{})));

        if (ChefScheduler.schedulable(requests) == false) {
            System.out.println("it should handle an example where there isn't enough coverage on a day.");
        }

        requests.clear();
        requests.put("ada", new ArrayList<>(Arrays.asList(new String[]{"mon", "tue", "wed", "thu", "fri", "sat"})));
        requests.put("emma", new ArrayList<>(Arrays.asList(new String[]{"tue", "wed", "thu", "sun"})));
        requests.put("remy", new ArrayList<>(Arrays.asList(new String[]{"mon", "fri", "sun"})));
        requests.put("zach", new ArrayList<>(Arrays.asList(new String[]{})));

        if (ChefScheduler.schedulable(requests) == false) {
            System.out.println("it should handle an example where an employee would need to work in excess of 5 days.");
        }
    }
}
