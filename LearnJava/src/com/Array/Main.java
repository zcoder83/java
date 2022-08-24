package com.Array;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        int[] numbers = {1, 2, 4, 5, 7, 9, -2, 3};
        int[] arrangedArray = new int[numbers.length];
        int lastIndex = numbers.length - 1;
        int firstIndex = 0;

        for (int i=0; i<numbers.length; i++) {
            if (numbers[i] % 2 == 1) {
                arrangedArray[firstIndex] = numbers[i];
                firstIndex++;
            } else {
                arrangedArray[lastIndex] = numbers[i];
                lastIndex--;
            }
        }
        copyArray(numbers, arrangedArray);
        System.out.println(Arrays.toString(numbers));
    }
    private static void copyArray(int[] numbers, int[] temp) {
        for (int i=0; i<numbers.length; i++) {
            numbers[i] = temp[i];
        }
    }
}
