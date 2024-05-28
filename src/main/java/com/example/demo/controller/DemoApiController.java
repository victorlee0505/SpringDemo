package com.example.demo.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.GreetingRequest;
import com.example.demo.model.GreetingResponse;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
@RequestMapping("/api")
public class DemoApiController {
    
    /**
     * NO INPUT
     * GET: Default greeting as String
     * http://localhost:8080/api/greeting
     * @return string
     */
    @GetMapping(value = { "/greeting" }, produces = "application/json")
    public String getHello() {
        log.info("/api/greeting Started");
        String result = "Hello World from Demo";
        log.info("/api/greeting Finished");
        return result;
    }

    /**
     * SIMPLE INPUT
     * POST: Default greeting as String with input
     * http://localhost:8080/api/greeting
     * @return
     */
    @PostMapping(value = { "/greeting" }, produces = "application/json")
    public ResponseEntity<String> postHello(@RequestBody String name) {
        log.info("/api/greeting Started");
        log.info("name : " + name);
        String message = "Hello World to " + name;
        log.info("/api/greeting/get Finished");
        return ResponseEntity.ok(message);
    }

    /**
     * SIMPLE INPUT, JSON OUTPUT
     * POST: Default greeting as JSON with input
     * http://localhost:8080/api/greeting/json1
     * @return
     */
    @PostMapping(value = { "/greeting/json1" }, produces = "application/json")
    public ResponseEntity<Map<String, String>> getGreeting(String name) {
        log.info("/api/greeting/json1 Started");
        ResponseEntity<Map<String, String>> entRes = null;
        Map<String, String> response = new HashMap<String, String>();
        response.put("service", "/api/greeting/json1");
        response.put("status", "Success");
        response.put("statusCode", "200");
        response.put("message", "Hello World to " + name);

        entRes = ResponseEntity.status(HttpStatus.OK).body(Collections.unmodifiableMap(response));
        log.info("/api/greeting/get Finished");
        return entRes;
    }

    /**
     * JSON INPUT, JSON OUTPUT
     * Default greeting as JSON with JSON input
     * http://localhost:8080/api/greeting/json2
     * @return
     */
    @PostMapping(value = { "/greeting/json2" }, produces = "application/json")
    public ResponseEntity<GreetingResponse> postGreeting2(@RequestBody GreetingRequest request) {
        log.info("/api/greeting/json2 Started");

        String service = "/api/greeting/json2";
        String status = "Sucess";
        String statusCode = "200";
        String message = "Hello World to " + request.getName() + ", You are " + request.getMessage();
        
        GreetingResponse response = GreetingResponse.builder()
                .service(service)
                .status(status)
                .statusCode(statusCode)
                .message(message)
                .build();

        log.info("/api/greeting/get Finished");
        return ResponseEntity.ok(response);
    }
}
