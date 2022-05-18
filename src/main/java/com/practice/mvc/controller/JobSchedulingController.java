package com.practice.mvc.controller;

import com.practice.scheduler.TaskDefinition;
import com.practice.scheduler.TaskDefinitionBean;
import com.practice.scheduler.TaskSchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping(path = "/schedule")
public class JobSchedulingController {

    @Autowired
    private TaskSchedulingService taskSchedulingService;

  /*  @Autowired
    private TaskDefinitionBean taskDefinitionBean;*/

    @PostMapping(path="/taskdef", consumes = "application/json", produces="application/json")
    public void scheduleATask(@RequestBody TaskDefinition taskDefinition) {
        //taskDefinitionBean.setTaskDefinition(taskDefinition);
        //taskSchedulingService.scheduleATask(String.valueOf(new Random().nextInt()), taskDefinitionBean, taskDefinition.getCronExpression());
        taskSchedulingService.scheduleATask(String.valueOf(new Random().nextInt()), taskDefinition);
    }

    @GetMapping(path="/remove/{jobid}")
    public void removeJob(@PathVariable String jobid) {
        taskSchedulingService.removeScheduledTask(jobid);
    }
}
