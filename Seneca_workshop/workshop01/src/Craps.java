
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

import java.util.Random;
import java.util.Scanner;

public class Craps {
	public static void main(String[] args) {
		int sum, point, dice1, dice2;
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);

		// execute 10 times
		for (int i = 0; i < 10; i++) {
			dice1 = rand.nextInt(6) + 1;
			dice2 = rand.nextInt(6) + 1;
			sum = dice1 + dice2;

			System.out.println(String.format("You rolled %d + %d = %d", dice1, dice2, sum));

			if (sum == 2 || sum == 3 || sum == 12) {
				System.out.println("Craps, Better Luck Next Time, You lose");
			} else if (sum == 7 || sum == 11) {
				System.out.println("Congratulations, You win");
			} else {
				point = sum;
				System.out.println(String.format("Point is (established) set to %d", point));
				// iterate until sum equals to point value or sum is 7
				do {
					dice1 = rand.nextInt(6) + 1;
					dice2 = rand.nextInt(6) + 1;
					sum = dice1 + dice2;

					System.out.println(String.format("You rolled %d + %d = %d", dice1, dice2, sum));

				} while (sum != 7 && sum != point);
				if (sum == 7) {
					System.out.println("Craps, Better Luck Next Time, You Lose");
				} else { // win the game when point equals to sum
					System.out.println("Congratulations, You Win");
				}
			}
			System.out.println("");
		}

	}
}
