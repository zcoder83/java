/**********************************************
 * Workshop 01 Course:Java for C++ Programmers Last Name: Jeong First Name:
 * Yeonkwan ID: 104069208 Section: JAC444ZCC This assignment represents my own
 * work in accordance with Seneca Academic Policy. Signature Date: 2022-02-02
 **********************************************/

public class MaxLocation {
	private int row;
	private int column;
	private int maxValue;

	public int getRow() {
		return row;
	}

	public int getCol() {
		return column;
	}

	public int getMax() {
		return maxValue;
	}

	public void findMaxLocation(int arr[][]) {

		int tempMax = 0; // initialise temporary max number as 0 to compare with other numbers.
		int comparingNum;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {

				comparingNum = arr[i][j];

				if (comparingNum > tempMax) { // compare numbers
					tempMax = comparingNum; // set bigger number to tempMax
					row = i; // assign row index
					column = j; // assign column index
				}
			}
		}
		// assign max value to member variable
		maxValue = arr[row][column];
	}
}