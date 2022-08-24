
/**********************************************
Workshop 01 
Course:Java for C++ Programmers
Last Name: Jeong
First Name: Yeonkwan
ID: 104069208
Section: JAC444ZCC
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 2022-02-02
**********************************************/
import java.util.*;
import java.util.Arrays;

public class MaxLocationDemo {
	public static void main(String[] args) {
		int row;
		int col;
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the number of rows and columns in the array: ");
		row = scan.nextInt();
		col = scan.nextInt();

		int[][] str = new int[row][col];

		System.out.println("Enter the array:");

		for (int i = 0; i < str.length; i++) {
			for (int j = 0; j < str[i].length; j++) {
				str[i][j] = scan.nextInt(); // retrieve numbers from user
			}
		}

		System.out.println(Arrays.deepToString(str)); // display the whole multiple dimensional array

		MaxLocation max = new MaxLocation();
		max.findMaxLocation(str); // execution to find max number

		System.out.println(String.format("The location of the largest element is %s at (%d, %d)", max.getMax(),
				max.getRow(), max.getCol()));
	}
}
