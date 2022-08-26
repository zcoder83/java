package workshop10;

import java.util.*;

public class UnsafeBank {

	static final int ID = 0;
	static final int LOAN = 1;
	static double[][][] mBanks;

	public static boolean[] scanBanks(double[][][] m, int limit) {

		boolean[] indexUnsafeBanks = new boolean[m.length];
		double total;
		boolean isSafe = false;
		
		while (!isSafe) {
			isSafe = true; 
			for (int banks = 0; banks < m.length; banks++) {
				total = m[banks][0][0];
				for (int LoanedBanks = 1; LoanedBanks < m[banks].length; LoanedBanks++) {
					int index = (int) m[banks][LoanedBanks][ID];
					if (!indexUnsafeBanks[index])
						total += m[banks][LoanedBanks][LOAN];
				}
				
				if (total < limit && !indexUnsafeBanks[banks]) {
					indexUnsafeBanks[banks] = true;
					isSafe = false;
				}
			}
		}
		return indexUnsafeBanks;
	}

	public static void displayMatrix(double[][][] m) {

		for (int banks = 0; banks < m.length; banks++) {
			System.out.println("For Bank #"+ banks);
			System.out.println("Balance: "+ m[banks][0][0]);
			System.out.printf("Number of banks Loaned: %d", m[banks].length - 1);
			System.out.println();
			
			
			for (int LoanedBanks = 1; LoanedBanks < m[banks].length; LoanedBanks++) {
				System.out.println("Bank ID who gets the loan: "+ (int)m[banks][LoanedBanks][ID]);
				System.out.println("Loaned Amount: "+ m[banks][LoanedBanks][LOAN]);
				
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		// First ask for number of banks and minimum limit
		System.out.print("Number of banks: ");
		int n = input.nextInt(); // n = number of banks
		System.out.print("Minimum asset limit: ");
		int limit = input.nextInt(); // limit is the minimum total assets for keeping a bank safe

		//mBanks = new double[n][][];

		mBanks = new double[][][] { 
				{ { 25, 0 }, { 1, 100.5 }, { 4, 320.5 } },
				{ { 125, 0 }, { 2, 40 }, { 3, 85 } }, 
				{ { 175, 0 }, { 0, 125 }, { 3, 75 } }, 
				{ { 75, 0 }, { 0, 125 } },
				{ { 181, 0 }, { 2, 125 } } };

		System.out.println("");
		displayMatrix(mBanks);
		boolean[] unsafeIndex = scanBanks(mBanks, limit); 
		
		
		//check how many unsafe banks are 
		for (int i = 0; i < unsafeIndex.length; i++) {
			if(unsafeIndex[i]) {
				System.out.println("Unsafe bank is " + i);
			}
		}

	}

}
