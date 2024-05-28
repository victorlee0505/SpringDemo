package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CalculateRequest;
import com.example.demo.model.CalculateResponse;
import com.example.demo.service.CalculatorService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/cal")
public class CalculatorApiController {
    
    /**
     * POST cal as JSON
     * http://localhost:8080/api/cal/post
     *  {
     *     "op": "+",
     *     "left": 3,
     *     "right": 3
     *  }
     * @return
     */
    @PostMapping(value = { "/post" }, produces = "application/json")
    public ResponseEntity<CalculateResponse> doMath(@RequestBody CalculateRequest request) {

        log.info("/cal/post Started");

        // New Java Object instantiated (if mulitple request, then multiple objects will be created)
        CalculatorService cal = new CalculatorService(request.getLeftOperand(), request.getRightOperand(), request.getOperator());

        CalculateResponse res = CalculateResponse.builder().request(request).message("Success").result(cal.calculate()).build();

        log.info("/cal/post Ended");
        
        return ResponseEntity.ok(res);
    }

}
