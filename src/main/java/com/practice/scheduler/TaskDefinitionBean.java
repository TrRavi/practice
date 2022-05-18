package com.practice.scheduler;

import org.springframework.stereotype.Service;

public class TaskDefinitionBean implements Runnable {

   private String actionType;
   private String actionData;

    public TaskDefinitionBean(String actionType, String actionData) {
        this.actionType = actionType;
        this.actionData = actionData;
    }

    @Override
    public void run() {
        System.out.println("Running action: " + actionType+"  with data: "+actionData);
        System.out.println();

    }


}