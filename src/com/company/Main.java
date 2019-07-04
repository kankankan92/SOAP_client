package com.company;

import com.company.client.CalculatorClient;
import com.company.client.NumberConversionClient;

import java.rmi.RemoteException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws RemoteException {

        while (true) {
            CalculatorClient calculatorClient = new CalculatorClient();
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите пример:");
            String string = sc.next();
            int result = calculatorClient.calculator(string);
            System.out.println(string + "=" + result + "(" + NumberConversionClient.numberConversion(result).trim() + ")");
        }


    }
}