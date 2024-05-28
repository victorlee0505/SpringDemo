package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TaskResult;

@Service
public class TaskProcessService {

    @Autowired
    private TaskProcessor processor;

    private final int TASK_NUM = 20;

    /**
     * singleThreadworkGenerator use processor.doWorkOneByOne
     */
    public List<TaskResult> singleThreadworkGenerator() {
        // Pool of tasks in here
        List<CompletableFuture<TaskResult>> futures = new ArrayList<CompletableFuture<TaskResult>>();

        for (int i = 1; i <= TASK_NUM; i++) {
            CompletableFuture<TaskResult> future = processor.doWorkOneByOne(i);
            // Collect task
            futures.add(future);
        }

        // Assume futures is now populated with CompletableFuture objects
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));

        // Now, we want to wait for all futures to complete...
        CompletableFuture<List<TaskResult>> allResultsFuture = allFutures.thenApply(v -> futures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList()));
        
        // We have all the results here
        List<TaskResult> results = allResultsFuture.join();
        return results;
    }

    /**
     * multiThreadsThreadworkGenerator use processor.doWorkTogether
     */
    public List<TaskResult> multiThreadsThreadworkGenerator() {
        // Pool of tasks in here
        List<CompletableFuture<TaskResult>> futures = new ArrayList<CompletableFuture<TaskResult>>();

        for (int i = 1; i <= TASK_NUM; i++) {
            CompletableFuture<TaskResult> future = processor.doWorkTogether(i);
            // Collect task
            futures.add(future);
        }

        // Assume futures is now populated with CompletableFuture objects
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));

        // Now, we want to wait for all futures to complete...
        CompletableFuture<List<TaskResult>> allResultsFuture = allFutures.thenApply(v -> futures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList()));
        
        // We have all the results here
        List<TaskResult> results = allResultsFuture.join();
        return results;
    }
}

