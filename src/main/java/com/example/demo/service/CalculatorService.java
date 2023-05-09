package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public boolean isMathOperator(String operator) {
        return operator.matches("[+\\-*/^]");
    }

    public double calculateResult(double leftOperand, double rightOperand, String operator) {
        double result = 0;
        switch(operator) {
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
                result = leftOperand / rightOperand;
                break;
            case "^":
                result = Math.pow(leftOperand, rightOperand);
                break;
            default:
                result = 0;
        }
        return result;
    }
}
