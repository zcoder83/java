package com.ClassAndObject;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        // this code is for Account class
        Account testAccount = new Account(1122, 20000, 4.5);

        if (testAccount.withdraw(2500)) {
            System.out.println("Widthraw successful!!!");
        } else {
            System.out.println("Failed: Not enough balance!!!");
        }
        testAccount.deposit(3000);
        System.out.println("Your account");
        System.out.println("ID: " + testAccount.getId());
        System.out.println("Balance: " + testAccount.getBalance());
        System.out.println("Annual Interest Rate: " + testAccount.getAnnualInterestRate());
        System.out.println("Created Date: " + testAccount.getDateCreated());

        // this code is for Rectangle class exercise
        //Scanner input = new Scanner(System.in);
        //Rectangle[] rectangles = new Rectangle[3];

        //for (int i=0; i<rectangles.length; ++i) {
        //    System.out.print("Would you like to enter width and height of rectangles? (y/n)");
        //    char choice = input.next().charAt(0);
        //    if (choice == 'y') {
        //        System.out.print("Enter width and height of " + (i+1) + " rectangle: ");
        //        rectangles[i] = new Rectangle(input.nextDouble(), input.nextDouble());
        //    } else {
        //        rectangles[i] = new Rectangle();
        //    }
        //}

        //for (int i=0; i<3; ++i) {
        //    System.out.println(rectangles[i].getWidth()+ " " + rectangles[i].getHeight());
        //}
    }
}
