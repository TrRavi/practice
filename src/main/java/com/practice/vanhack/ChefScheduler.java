package com.practice.vanhack;

import java.util.*;

public class ChefScheduler {
    private static List<String> days = Arrays.asList("mon", "tue", "wed", "thu", "fri", "sat", "sun");
    private static Map<String, Integer> workerNoOfWorkingDaya = new HashMap<>();

    public static boolean schedulable(HashMap<String, ArrayList<String>> requests) {
        List<String> workers = new ArrayList<>(requests.keySet());
        if (workers.size() <= 3) return false;

        Map<String, List<String>> leaveDayOfWorker = new HashMap<>();
        requests.forEach((worker, dayList) -> {
            workerNoOfWorkingDaya.put(worker, 0);
            for (String day : dayList) {
                if (leaveDayOfWorker.containsKey(day)) {
                    leaveDayOfWorker.get(day).add(worker);
                } else {
                    List<String> tempWorker = new ArrayList<>();
                    tempWorker.add(worker);
                    leaveDayOfWorker.put(day, tempWorker);
                }
            }
        });

        Map<String, List<String>> workerWorkingDay = new HashMap<>();

        for (int i = 0; i < days.size(); i++) {
            String day = days.get(i);
            List<String> workerOnLeave = leaveDayOfWorker.get(day);
            List<String> workerOnWork = new ArrayList<>();
            for (int j = 0; j < workers.size(); j++) {
                String worker = workers.get(j);
                if (!workerOnLeave.contains(worker) && workerNoOfWorkingDaya.get(worker) < 5) {
                    workerOnWork.add(worker);
                    addWorkingDaya(worker);
                }
                if (workerOnWork.size() == 2) break;
            }
            workerWorkingDay.put(day, workerOnWork);
            if (workerOnWork.size() != 2) {
                return false;
            }
        }

        return true;
    }

    private static void addWorkingDaya(String worker) {
        int day = 1;
        if (workerNoOfWorkingDaya.containsKey(worker)) {
            day += workerNoOfWorkingDaya.get(worker);
        }
        workerNoOfWorkingDaya.put(worker, day);
    }
}
