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

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CheckLetters {

	  public static void main(String[] args) throws IOException { 
	    Scanner input = new Scanner(System.in);
	    int[] arrayU = new int[26];
	    String[] alphabetsU = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", 
	            "T", "U", "V", "W", "X", "Y", "Z"};
	    int[] arrayL = new int[26];
	    String[] alphabetsL = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", 
	            "t", "u", "v", "w", "x", "y", "z"};

	    
	    System.out.print("Enter a file name: ");
	    String fileName = input.nextLine();
	   
	    File file = new File(fileName);

	    //check if the file exist
	    if(!file.exists()){
	        System.out.println("The file " + fileName + " does not exist.");
	        System.exit(0);
	    }

	    
	    Scanner inputFile = new Scanner(file);

	    String line = null;
	    int tmp;
	    while(inputFile.hasNextLine()){
	         line = inputFile.nextLine();
	         for(int i=0; i<line.length(); i++) {
	             tmp = line.charAt(i) - 97;
	             if(tmp < 26 && tmp >= 0)
	                 arrayL[tmp]++;
	         }
	         for(int i=0; i<line.length(); i++) {
	             tmp = line.charAt(i) - 65;
	             if(tmp < 26 && tmp >= 0)
	                 arrayU[tmp]++;
	         }
	    }

	    
	    inputFile.close();

	    for (int i = 0; i < alphabetsL.length; i++) {
	    	if(arrayU[i] > 0) {
		    	System.out.println("Number of " + alphabetsU[i] + "'s: " + arrayU[i]);
		    }
	    	if(arrayL[i] > 0) {
	        	System.out.println("Number of " + alphabetsL[i] + "'s: " + arrayL[i]);
	        }
	    }

	  }
	}
