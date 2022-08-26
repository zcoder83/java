package com.ArrayList;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int choice = 100;
        ArrayList<Integer> numbers = new ArrayList<>();

        Scanner input = new Scanner(System.in);

        do {
            // print menu
            System.out.println(
                    "1. Add\n" + "2. Remove\n" + "3. Display\n" + "4. Exit\n"
            );
            System.out.print("Your Choice: ");
            choice = input.nextInt();

            // execute by choice
            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter Number: ");
                        numbers.add(input.nextInt());
                        System.out.println("Added!!!");
                    } catch (Exception e) {
                        System.out.println("not valid!!!");
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        System.out.print("Enter number: ");
                        int temp = input.nextInt();
                        if (numbers.contains(temp)){
                            numbers.remove(numbers.indexOf(temp));
                            System.out.println("Removed!!!");
                        } else {
                            System.out.println("Not found!!!");
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    System.out.println(numbers);
                    break;
                case 4:
                    choice = 4;
                    break;
            }

        } while (choice != 4);
    }
    //public  static void main(String[] args) {
    //    ArrayList<Integer> numbers = new ArrayList<>();
    //    Scanner sc = new Scanner(System.in);
    //    System.out.print("Enter 5 integers: ");
    //    for (int i=0; i<5; ++i) {
    //        int temp = sc.nextInt();
    //        if (!numbers.contains(temp)) {
    //            numbers.add(temp);
    //        }
    //    }
    //    Collections.sort(numbers);
    //    System.out.println(numbers);
    //}
    //public static void main(String[] args) {
    //    // assign elements of array from user
    //    int sizeOfArray;
    //    Scanner sc = new Scanner(System.in);
    //    System.out.print("Enter ");
    //    sizeOfArray = sc.nextInt();
    //    int[] numbers = new int[sizeOfArray];
    //    System.out.print("integers: ");
    //    for (int i = 0; i < sizeOfArray; ++i) {
    //        numbers[i] = sc.nextInt();
    //    }
    //    // to assign unique value into array
    //    ArrayList<Integer> uniqueArray = new ArrayList<>();

    //    uniqueArray.add(numbers[0]);
    //    for (int i = 1; i < sizeOfArray; ++i) {
    //        boolean isEqual = false;
    //        for (int j = 0; j < uniqueArray.size(); ++j) {
    //            if (uniqueArray.get(j) == numbers[i]) {
    //                isEqual = true;
    //            }

    //        }
    //        if (!isEqual) {
    //            uniqueArray.add(numbers[i]);
    //        }

    //    }
    //    Collections.sort(uniqueArray);
    //    for (int number : uniqueArray) {
    //        System.out.print(number + " ");
    //    }
    //}
}
