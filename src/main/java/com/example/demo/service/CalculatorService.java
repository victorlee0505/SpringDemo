package com.example.demo.service;

/**
 * CalculatorService
 * Simple Java class ( not spring bean / managed)
 */
public class CalculatorService {
    private double leftOperand;
    private double rightOperand;
    private String operator;

    public CalculatorService(double leftOperand, double rightOperand, String operator) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operator = operator;
    }

    public double calculate() {
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

    public double getLeftOperand() {
        return leftOperand;
    }

    public void setLeftOperand(double leftOperand) {
        this.leftOperand = leftOperand;
    }

    public double getRightOperand() {
        return rightOperand;
    }

    public void setRightOperand(double rightOperand) {
        this.rightOperand = rightOperand;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    
}
