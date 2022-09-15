package com.Lambda;

import java.util.Scanner;

interface PerformOperation {
    boolean check(int num);
}

public class Lambda {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int times =  input.nextInt();
        PerformOperation po;
        while (times-- > 0){
            int select = Integer.parseInt(input.next());
            int number = Integer.parseInt(input.next());
            if(select == 1) {
                po = (n) -> n % 2 != 0;
                System.out.println((po.check(number)) ? "ODD" : "EVEN");
            } else if (select ==2) {
                po = (a) -> java.math.BigInteger.valueOf(a).isProbablePrime(1);
                System.out.println((po.check(number)) ? "PRIME" : "COMPOSITE");
            } else if (select == 3) {
                po = (a) -> Integer.toString(a).equals(new StringBuilder(Integer.toString(a)).reverse().toString());
                System.out.println((po.check(number)) ? "PALINDROME" : "NOT PALINDROME");
            }
        }
    }
}
