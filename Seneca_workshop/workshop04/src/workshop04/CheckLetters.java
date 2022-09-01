/**********************************************
 Workshop 04
 Course:Java for C++ Programmers
 Last Name: Jeong
 First Name: Yeonkwan
 ID: 104069208
 Section: JAC444ZCC
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature
 Date: 2022-02-28
 **********************************************/

package workshop04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CheckLetters {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int[] arrayUpperCase = new int[26];
        String[] alphabetsU = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        int[] arrayLowCase = new int[26];
        String[] alphabetsL = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};


        System.out.print("Enter a file name: ");
        String fileName = input.nextLine();

        File file = new File(fileName);

        //check if the file exist
        if (!file.exists()) {
            System.out.println("The file " + fileName + " does not exist.");
            System.exit(0);
        }


        String line;
        int tmp; // index of alphabet

        BufferedReader reader = new BufferedReader(new FileReader("text.txt"));
        while ((line = reader.readLine()) != null) {
            for (int i = 0; i < line.length(); i++) {
                // a's ascii is 97
                tmp = (int)line.charAt(i) - 97; // type conversion and assign index of alphabet to tmp
                if (tmp < 26 && tmp >= 0)
                    arrayLowCase[tmp]++; // increment 1
            }
            for (int i = 0; i < line.length(); i++) {
                // A's ascill is 65
                tmp = (int)line.charAt(i) - 65;
                if (tmp < 26 && tmp >= 0)
                    arrayUpperCase[tmp]++;
            }
        }
        reader.close();
        for (int i = 0; i < alphabetsL.length; i++) {
            if (arrayUpperCase[i] > 0) {
                System.out.println("Number of " + alphabetsU[i] + "'s: " + arrayUpperCase[i]);
            }
            if (arrayLowCase[i] > 0) {
                System.out.println("Number of " + alphabetsL[i] + "'s: " + arrayLowCase[i]);
            }
        }

    }
}
