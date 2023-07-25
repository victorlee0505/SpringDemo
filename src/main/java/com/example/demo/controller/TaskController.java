package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.helper.TaskResult;
import com.example.demo.service.TaskProcessService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/work")
@Slf4j
public class TaskController {

    @Autowired
    private TaskProcessService service;
    
    /**
     * GET: Default greeting as String
     * http://localhost:8080/work/single
     * @return string
     */
    @GetMapping(value = { "/single" }, produces = "application/json")
    public String workAlone() {
        log.info("/work/single Started");
        final long start = System.currentTimeMillis();

        int counter = 0;
        List<TaskResult> results = service.singleThreadworkGenerator();
        for (TaskResult taskResult : results) {
            if(!taskResult.isStatus()){
                counter++;
            }
        }

        final long end = System.currentTimeMillis();
		final long duration = (end - start) / 1000;

        String result = "Duration: " + duration + "s, Failed task: " + counter;
        log.info(result);
        log.info("/work/single Finished");
        return result;
    }

    /**
     * GET: Default greeting as String
     * http://localhost:8080/work/multi
     * @return string
     */
    @GetMapping(value = { "/multi" }, produces = "application/json")
    public String workTogether() {
        log.info("/work/multi Started");
        final long start = System.currentTimeMillis();

        int counter = 0;
        List<TaskResult> results = service.multiThreadsThreadworkGenerator();
        for (TaskResult taskResult : results) {
            if(!taskResult.isStatus()){
                counter++;
            }
        }

        final long end = System.currentTimeMillis();
		final long duration = (end - start) / 1000;

        String result = "Duration: " + duration + "s, Failed task: " + counter;
        log.info(result);
        log.info("/work/multi Finished");
        return result;
    }
}
