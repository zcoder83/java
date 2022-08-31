package com.Yeon;

import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Yeon yeon = new Yeon();
    }
}
//public class Main {
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//
//        System.out.print("Enter a number 1 to 20: ");
//
//        int enteredNumber = input.nextInt();
//
//        while(enteredNumber < 1 || enteredNumber > 20){
//            System.out.println("This number is not valid");
//            enteredNumber = input.nextInt();
//        }
//        Point[] pointArray = new Point[enteredNumber];
//
//        fillArrayOfNumbers(pointArray);
//        printArrayOfNumbers(pointArray);
//    }
//    private static void fillArrayOfNumbers(Point[] pointArray){
//        Scanner input = new Scanner(System.in);
//        int x, y;
//        for(int i=0; i<pointArray.length; i++){
//            System.out.print("Enter x: ");
//            x = input.nextInt();
//            System.out.print("Enter y: ");
//            y = input.nextInt();
//
//            pointArray[i] = new Point(x, y);
//        }
//    }
//    private static void printArrayOfNumbers(Point[] pointArray){
//        for (int i=0; i<pointArray.length; i++){
//            System.out.println("( " + pointArray[i].x + ", " + pointArray[i].y + " )");
//        }
//    }
//}
