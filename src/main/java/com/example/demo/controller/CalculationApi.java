package com.example.demo.controller;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
public class CalculationApi {

    @Autowired
    private CalculatorService cal;
    
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

        if(!isValidCalculateRequest(request)){
            CalculateResponse res = CalculateResponse.builder().request(request).message("Invalid Request!").build();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
        }

        // New Java Object instantiated
        // CalculatorService cal = new CalculatorService(request.getLeftOperand(), request.getRightOperand(), request.getOperator());

        if(!cal.isMathOperator(request.getOperator())){
            CalculateResponse res = CalculateResponse.builder().request(request).message("Invalid Operator! Please use one of [ + - * / ^ ].").build();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
        }

        CalculateResponse res = CalculateResponse.builder().request(request).message("Success").result(cal.calculateResult(request.getLeftOperand(), request.getRightOperand(), request.getOperator())).build();

        log.info("/cal/post Ended");
        
        return ResponseEntity.ok(res);
    }

    private boolean isValidCalculateRequest(CalculateRequest request) {
        if (request != null) {
            if (ObjectUtils.allNotNull(request.getOperator(), request.getLeftOperand(), request.getRightOperand())) {
                if (StringUtils.isNotBlank(request.getOperator())) {
                    return true;
                }
            }
        }
        return false;
    }
}
