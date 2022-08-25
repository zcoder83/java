package com.twoDimensionalArray;

public class Main {
    public static void main(String[] args) {
        int[][] integers = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        printArrayByRow(integers);
        printArrayByColumn(integers);
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
