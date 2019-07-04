package com.company.client;

import com.company.calc.CalculatorStub;
import org.tempuri.*;

import java.rmi.RemoteException;
import java.util.Scanner;

public class CalculatorClient {

    public int calculator(String expression) throws RemoteException {
        if (expression.contains("-")) {
            String values[] = expression.split("-");
            int a = Integer.parseInt(values[0]);
            int b = Integer.parseInt(values[1]);
            return divide(a, b);
        } else if (expression.contains("/")) {
            String values[] = expression.split("/");
            int a = Integer.parseInt(values[0]);
            int b = Integer.parseInt(values[1]);
            return subtract(a, b);
        } else if (expression.contains("*")) {
            String values[] = expression.split("\\*");
            int a = Integer.parseInt(values[0]);
            int b = Integer.parseInt(values[1]);
            return multiply(a, b);
        } else if (expression.contains("+")) {
            String values[] = expression.split("\\+");
            int a = Integer.parseInt(values[0]);
            int b = Integer.parseInt(values[1]);
            return add(a, b);
        } else {
            throw new RuntimeException("Некорректный ввод примера");
        }
    }

    private int add(int a, int b) throws RemoteException {
        CalculatorStub calculatorStub = new CalculatorStub();
        Add add = new Add();
        add.setIntA(a);
        add.setIntB(b);
        AddResponse addResponse = calculatorStub.add(add);
        return addResponse.getAddResult();
    }

    private int multiply(int a, int b) throws RemoteException {
        CalculatorStub calculatorStub = new CalculatorStub();
        Multiply multiply = new Multiply();
        multiply.setIntA(a);
        multiply.setIntB(b);
        MultiplyResponse multiplyResponse = calculatorStub.multiply(multiply);
        return multiplyResponse.getMultiplyResult();
    }

    private int divide(int a, int b) throws RemoteException {
        CalculatorStub calculatorStub = new CalculatorStub();
        Divide divide = new Divide();
        divide.setIntA(a);
        divide.setIntB(b);
        DivideResponse divideResponse = calculatorStub.divide(divide);
        return divideResponse.getDivideResult();
    }

    private int subtract(int a, int b) throws RemoteException {
        CalculatorStub calculatorStub = new CalculatorStub();
        Subtract subtract = new Subtract();
        subtract.setIntA(a);
        subtract.setIntB(b);
        SubtractResponse subtractResponse = calculatorStub.subtract(subtract);
        return subtractResponse.getSubtractResult();
    }
}
