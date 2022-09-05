package com.Yeon;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.*;


public class Main {

public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        //String[] firstMultipleInput = bufferedReader.readLine().split(" ");

        int month = Integer.parseInt(firstMultipleInput[0]);

        int day = Integer.parseInt(firstMultipleInput[1]);

        int year = Integer.parseInt(firstMultipleInput[2]);

    System.out.println(month + " " + day + " " + year);

        bufferedReader.close();
        //bufferedWriter.close();
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
