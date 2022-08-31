package com.ClassAndObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Client client = new Client(1, "yeon", "333-3333");

        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account(1111, 1000, 1.5, client));
        accounts.add(new Account(1112, 2000, 2.5, client));

        accounts.get(0).deposit(300);
        accounts.get(0).withdraw(500);
        accounts.get(1).withdraw(800);
        System.out.println(client);
        for (Account account : accounts) {
            System.out.println(account.toString() + "Withdraw: "+ account.countTransaction('W') + ", Deposit: " + account.countTransaction('D'));
        }
        //clients[0].addAccount(new Account(1111, 1000, 1.5));
        //clients[0].addAccount(new Account(1112, 2000, 2.5));
        //clients[1].addAccount(new Account(2111, 3000, 3.5));
        //clients[1].addAccount(new Account(2112, 5000, 4.5));
        //clients[1].addAccount(new Account(2113, 1000, 1.5));


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
