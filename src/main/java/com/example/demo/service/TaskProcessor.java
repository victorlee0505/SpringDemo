package com.example.demo.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.example.demo.model.TaskResult;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TaskProcessor {
    @Async("singleThread")
	public CompletableFuture<TaskResult> doWorkOneByOne(int workNumber) {
        
		try {
			Thread.sleep(10 * 1000);
            String msg = "Process #" + workNumber + "Done!";
            TaskResult result = TaskResult.builder().message(msg).status(true).build();
            log.info(msg);
			return CompletableFuture.completedFuture(result);
		}
		catch(InterruptedException ie) {
			log.error(ie.getMessage());
		}
		String msg = "Process #" + workNumber + "Failed";
        TaskResult result = TaskResult.builder().message(msg).status(true).build();
        log.info(msg);
		return CompletableFuture.completedFuture(result);
	}

    @Async("multiThread")
	public CompletableFuture<TaskResult> doWorkTogether(int workNumber) {
		try {
			Thread.sleep(10 * 1000);
			String msg = "Process #" + workNumber + "Done!";
            TaskResult result = TaskResult.builder().message(msg).status(true).build();
            log.info(msg);
			return CompletableFuture.completedFuture(result);
		}
		catch(InterruptedException ie) {
			log.error(ie.getMessage());
		}
		String msg = "Process #" + workNumber + "Failed";
        TaskResult result = TaskResult.builder().message(msg).status(true).build();
        log.info(msg);
		return CompletableFuture.completedFuture(result);
	}
}
