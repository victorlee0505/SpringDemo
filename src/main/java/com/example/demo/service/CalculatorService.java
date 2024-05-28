package com.example.demo.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * CalculatorService
 * Simple Java class ( not spring bean / managed)
 */

@AllArgsConstructor
@Getter
@Setter
public class CalculatorService {
    private double leftOperand;
    private double rightOperand;
    private String operator;

    public double calculate() {
        double result = 0;
        switch (operator) {
            case "+":
                result = this.leftOperand + this.rightOperand;
                break;
            case "-":
                result = this.leftOperand - this.rightOperand;
                break;
            case "*":
                result = this.leftOperand * this.rightOperand;
                break;
            case "/":
                // check if rightOperand is 0
                if (this.rightOperand == 0) {
                    throw new ArithmeticException("Division by zero is not allowed");
                }
                result = this.leftOperand / this.rightOperand;
                break;
            default:
                break;
        }
        return result;
    }
}
