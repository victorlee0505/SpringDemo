package com.example.demo.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CalculatorService {
    private double leftOperand;
    private double rightOperand;
    private String operator;

    public boolean isMathOperator() {
        return this.operator.matches("[+\\-*/^]");
    }

    public double calculateResult() {
        double result = 0;
        switch(this.operator) {
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
                result = this.leftOperand / this.rightOperand;
                break;
            case "^":
                result = Math.pow(this.leftOperand,this.rightOperand);
                break;
            default:
                result = 0;
        }
        return result;
    }
}
