package com.example.unitest.unitest.junit5;

public class Calculator {

    private int result;

    public int add(int n1, int n2){
        result = n1 + n2;
        return result;
    }

    public int subtract(int n1, int n2){
        result = n1 - n2;
        return result;
    }

    public int divided(int n1, int n2){
        result = n1 / n2;
        return result;
    }

    public int dividedByZero(int n1, int n2){
        if(n2 == 0){
            throw new ArithmeticException("No se puede dividir por cero");
        }
        result = n1 / n2;
        return result;
    }
}