package com.example.demo.task.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TaskResult;
import com.example.demo.service.TaskProcessService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TaskController implements TaskApi {

    private final TaskProcessService taskProcessService;

    /**
     * GET /task/run : to run all tasks
     * 
     * http://localhost:8080/task/run
     * http://localhost:8080/task/run?async=true
     */
    @Override
    public ResponseEntity<Void> getAllTasks(@Valid Boolean async) {

        log.info("getAllTasks called with async={}", async);

        CompletableFuture.runAsync(() -> {
            log.info("/work/multi is running");
            final long start = System.currentTimeMillis();
            int counter = 0;
            List<TaskResult> results = null;
            if (async) {
                results = taskProcessService.multiThreadsThreadworkGenerator();
            } else {
                results = taskProcessService.singleThreadworkGenerator();
            }
            for (TaskResult taskResult : results) {
                if (!taskResult.isStatus()) {
                    counter++;
                }
            }
            final long end = System.currentTimeMillis();
            final long duration = (end - start) / 1000;
            String result = "Duration: " + duration + "s, Failed task: " + counter;
            log.info(result);
            log.info("/work/multi Finished");
        });

        return ResponseEntity.accepted().build();
    }

}