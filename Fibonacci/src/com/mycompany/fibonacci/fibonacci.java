/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fibonacci;

import java.util.Scanner;
import java.math.BigInteger;
import java.util.InputMismatchException;

/**
 *
 * @author Philip McCrickard
 * 
 */
public class fibonacci {

    private static Scanner input;

	/**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        BigInteger fibArr[] = new BigInteger[2000];
        BigInteger fibModArr[] = new BigInteger[1001];

        createFibArray(fibArr);// creates Fibonacci array
        createFibModArray(fibArr, fibModArr);
        int choice;
        do {
            menu();
            input = new Scanner(System.in);//changes to input scanners
            System.out.println("Choose an option");
            choice = input.nextInt();
            switch (choice) {
            case 1:// first n fib numbers
                printFibArr(fibArr);
                break;
            case 2:// nth fib number
                input = new Scanner(System.in);

                System.out.println("enter 'n'");
                try {
                    int n = input.nextInt();
                    System.out.println("the " + n + "th Fibonacci number is " + fibArr[n - 1]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Enter a value for 'n' between 1 and 1000");
                } 
           

                break;
            case 3:// fib mod sequence
                printFibModArray(fibModArr);
                break;
            case 4:// nth in fib mod sequence
                input = new Scanner(System.in);
                System.out.println("enter 'm'");
                try {
                    int m = input.nextInt();
                    System.out.println("for modulus " + m + " it repeats every " + fibModArr[m] + " in the sequence.");
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Enter a value for 'n' between 1 and 1000");
                } 

                break;
            default:// quit
                break;

            }

        } while (choice != 5);

    }

    /**
     * creates array of fibonacci numbers
     * 
     * @param fibArr a blank array of length n with n being the nth fib number
     */
    public static void createFibArray(BigInteger fibArr[]) {

        fibArr[0] = BigInteger.valueOf(1);
        fibArr[1] = BigInteger.valueOf(1); // set first entries to 1
        for (int i = 2; i < fibArr.length; i++)// iterates to end of array
        {
            fibArr[i] = fibArr[i - 1].add(fibArr[i - 2]);// adds previos two elements together to get value
        }
    }

    /**
     * creates array filled with Fib mod n 1-1000
     * 
     * @param fibArr    fibonacci array filled with Fibonacci sequence
     * @param fibModArr blank array to be filled with these numbers
     */
    public static void createFibModArray(BigInteger fibArr[], BigInteger fibModArr[]) {
        for (int m = 1; m < 1001; m++)// iterates through values to modulus divide the fibonacci series by (1-1000)
        {
            BigInteger pattern = BigInteger.valueOf(0);
            boolean patternFlag = false;// flag to make sure that additional even divisions don't get counted
            for (int i = 0; i < fibArr.length; i++) {
                if (fibArr[i].mod(BigInteger.valueOf(m)) == BigInteger.valueOf(0) && patternFlag == false) {
                    pattern = BigInteger.valueOf(i + 1);
                    patternFlag = true;
                }
            }
            fibModArr[m] = pattern;
        }

    }

    /**
     * Prints Fibonacci Array
     * 
     * @param fibArr Array of Fibonacci numbers
     */
    public static void printFibArr(BigInteger fibArr[]) {
        
        System.out.println("enter 'n'");
        try {
            int n = input.nextInt();
            System.out.print("{");
            for (int i = 0; i < n - 1; i++)
                System.out.print(fibArr[i] + ", ");
            System.out.println(fibArr[n - 1] + "}");
        } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
            System.out.println("Please select a value for n between 1 and 1000");
        } 

    }

    /**
     * Prints Fib mod numbers
     * 
     * @param fibModArr Array of fib mod numbers
     */
    public static void printFibModArray(BigInteger fibModArr[]) {
        for (int i = 1; i < fibModArr.length; i++)
            System.out.print(fibModArr[i] + " ");
    }

    /**
     * displays menu
     */
    private static void menu() {
        System.out.println("------------------------------------------\n"
                + "|                  MENU                  |\n" + "| 1 Print out first n Fibonacci numbers  |\n"
                + "| 2 Return nth Fibonacci number          |\n" + "| 3 Print out Fib mod sequence           |\n"
                + "| 4 Return Fibonacci mod n               |\n" + "| 5 Quit                                 |\n"
                + "------------------------------------------  ");

    }

}