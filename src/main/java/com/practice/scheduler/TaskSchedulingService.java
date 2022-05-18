package com.practice.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.TimeZone;
import org.springframework.scheduling.support.CronTrigger;

@Service
public class TaskSchedulingService {

    @Autowired
    private TaskScheduler taskScheduler;

    Map<String, ScheduledFuture<?>> jobsMap = new HashMap<>();

    /*public void scheduleATask(String jobId, Runnable tasklet, String cronExpression) {
        System.out.println("Scheduling task with job id: " + jobId + " and cron expression: " + cronExpression);
        ScheduledFuture<?> scheduledTask = taskScheduler.schedule(tasklet, new CronTrigger(cronExpression, TimeZone.getTimeZone(TimeZone.getDefault().getID())));
        jobsMap.put(jobId, scheduledTask);
    }*/

    private ScheduledFuture scheduleATask(Runnable task,String cronExpression){
        ScheduledFuture<?> scheduledTask = taskScheduler.schedule(task, new CronTrigger(cronExpression, TimeZone.getTimeZone(TimeZone.getDefault().getID())));
        return scheduledTask;
    }

    public void removeScheduledTask(String jobId) {
        ScheduledFuture<?> scheduledTask = jobsMap.get(jobId);
        if(scheduledTask != null) {
            scheduledTask.cancel(true);
            jobsMap.put(jobId, null);
        }
    }

    public void scheduleATask(String jobId, TaskDefinition taskDefinition) {
        System.out.println("Scheduling task with job id: " + jobId + " and cron expression: " + taskDefinition.getCronExpression());
        TaskDefinitionBean task = new TaskDefinitionBean(taskDefinition.getActionType(),taskDefinition.getData());
        jobsMap.put(jobId, scheduleATask(task,taskDefinition.getCronExpression()));
    }
}
