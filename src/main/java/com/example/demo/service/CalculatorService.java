package com.example.demo.service;

import org.springframework.stereotype.Service;

/**
 * CalculatorService
 * Spring Bean
 */
@Service
public class CalculatorService {

    public double calculate(double leftOperand, double rightOperand, String operator) {
        double result = 0;
        switch (operator) {
            case "+":
                result = leftOperand + rightOperand;
                break;
            case "-":
                result = leftOperand - rightOperand;
                break;
            case "*":
                result = leftOperand * rightOperand;
                break;
            case "/":
                // check if rightOperand is 0
                if (rightOperand == 0) {
                    throw new ArithmeticException("Division by zero is not allowed");
                }
                result = leftOperand / rightOperand;
                break;
            default:
                break;
        }
        return result;
    }
}
