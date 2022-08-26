package com.twoDimensionalArray;

public class Main {
    public static void main(String[] args) {
        int[][] integers = {
                {1, 10, 3, 8},
                {9, 12, 6, 7},
                {5, 2, 11, 4}
        };
        getMaxNumber(integers);
        //printArrayByRow(integers);
        //printArrayByColumn(integers);
    }

    public static void getMaxNumber(int[][] integers) {
        int maxNumber;
        for (int i = 0; i < integers.length; i++) {
            maxNumber = integers[i][0];
            for (int j = 1; j < integers[i].length; j++) {
                if (maxNumber < integers[i][j]) {
                    maxNumber = integers[i][j];
                }
            }
            System.out.println("Max of Row " + (i + 1) + ": " + maxNumber);
        }
    }
    public static void printArrayByRow(int[][] integers) {
        for (int i=0; i<integers.length; i++){
            int sum = 0;
            for (int j=0; j<integers[i].length; j++) {
                sum += integers[i][j];
            }
            System.out.println("Sum of Row " + (i+1) + ": " + sum);
        }
    }
    public static void printArrayByColumn(int[][] integers) {
        for (int i=0; i<integers[0].length; i++){
            int sum = 0;
            for (int j=0; j<integers.length; j++) {
                sum += integers[j][i];
            }
            System.out.println("Sum of Column " + (i+1) + ": " + sum);
        }
    }
}
