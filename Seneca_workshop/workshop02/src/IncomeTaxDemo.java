/**********************************************
Workshop 02 
Course:Java for C++ Programmers
Last Name: Jeong
First Name: Yeonkwan
ID: 104069208
Section: JAC444ZCC
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 2022-02-15
**********************************************/

import java.util.*;
public class IncomeTaxDemo {
	
	//tax interval array
	private static int[][] tax2001 = new int[][] {
		{27050, 45200, 22600, 36250},
		{65550, 109250, 54625, 93650},
		{136750, 166500, 83250, 151650},
		{297350, 297350, 148675, 297350},
		{297351, 297351, 148676, 297351}
	};
	private static int[][] tax2009 = new int[][] {
		{8350, 16700, 8350, 11950}, 
		{33950, 67900, 33950, 45500}, 
		{82250, 137050, 68525, 117450}, 
		{171550, 208850, 104425, 190200},
		{372950, 372950, 186475, 372950},
		{372951, 372951, 186476, 372951}
	};
	
	//tax rates array
	private static double[] rates2001 = new double[] {15, 27.5, 30.5, 35.5, 39.1};
	private static double[] rates2009 = new double[] {10, 15, 25, 28, 33, 35};
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int userInput = -100;

		do {
			// display menu
			System.out.println("1 - Compute personal income Tax");
			System.out.println("2 - Print the tax tables for taxable incomes (with range)");
			System.out.println("3 - Exit");

			userInput = scan.nextInt();
			
			// validate user input
			if (userInput < 1 || userInput > 3) {
				System.out.println("Please enter 1 or 2 or 3");
				continue; // return the beginning of the loop
			}
			
			// choice 01
			if (userInput == 1) {
				System.out.println();
				int tempStatus = 0;
				double tempIncome = 0;

				boolean valid = true; // loop trigger
				
				do {
					// display sub menu
					System.out.println("0 - single filer");
					System.out.println("1 - married jointly or qualifying widow(er)");
					System.out.println("2 - married separately");
					System.out.println("3 - head of household)");
					System.out.print("Enter the filing status:");
					tempStatus = scan.nextInt();
					System.out.print("Enter the Taxable Income:$");
					tempIncome = scan.nextDouble();
					
					// validate user input
					if (tempStatus < 0 || tempStatus > 3) {
						System.out.println("\nPlease enter the number between 0 and 3\n");
					} else if (tempIncome < 0) {
						System.out.println("\nPlease enter the number greater than 0\n");
					} else {
						valid = false;
					}

				} while (valid);

				IncomeTax tax = new IncomeTax(tempStatus, tax2009, rates2009, tempIncome);

				System.out.println(String.format("Tax is: $%.2f", tax.getIncomeTax()));

			}
			// choice 02
			if (userInput == 2) {
				
				int amountFrom;
				int amountTo;
				
				boolean valid = true;
				
				do {
					System.out.print("Enter the amount From: $");
					amountFrom = scan.nextInt();
					System.out.print("Enter the amount To: $");
					amountTo = scan.nextInt();
					
					// validate user input
					if (amountFrom > 0 && amountTo > 0 && amountTo > amountFrom) {
						valid = false;
					} else {
						System.out.println(
								"\nPlease enter positive amount and amount-to should be bigger than amount-from\n");
					}
				} while (valid);

				IncomeTax taxTable2001 = new IncomeTax();
				IncomeTax taxTable2009 = new IncomeTax();
				taxTable2001.setIntervals(tax2001);
				taxTable2001.setRates(rates2001);
				taxTable2009.setIntervals(tax2009);
				taxTable2009.setRates(rates2009);
				
				// display tax tables
				System.out.println("\n2001 tax tables  for taxable income from $" + amountFrom + " to $" + amountTo);
				displayTable(taxTable2001, amountFrom, amountTo);
				System.out.println("\n2009 tax tables  for taxable income from $" + amountFrom + " to $" + amountTo);
				displayTable(taxTable2009, amountFrom, amountTo);

			}
			System.out.println();

		} while (userInput != 3);
		System.out.println("Good bye!"); // exit 
	}

	public static void displayTable(IncomeTax obj, int from, int to) {
		System.out.println("-----------------------------------------------------------------");
		System.out.printf("\n%-10s%-15s%-15s%-15s%-15s\n", "Taxable", "Single", "Married Joint", "Married", "Head of ");
		System.out.printf("%-10s%-15s%-15s%-15s%-15s\n", "Income", "", "or Qualifying", "Separate", "a House");

		System.out.printf("%-10s%-15s%-15s%-15s%-15s\n", "", "", "Window(er)", "", "");

		System.out.println("-----------------------------------------------------------------");
		for (int amtFrom = from; amtFrom <= to; amtFrom += 1000) {
			System.out.printf("%-10d", amtFrom);
			// i indicates status
			for (int i = 0; i < 4; i++) {

				obj.setFilingStatus(i);
				obj.setTaxableIncome(amtFrom);

				System.out.printf("%-15.2f", obj.getIncomeTax());
			}
			System.out.println();
		}
	}

}
