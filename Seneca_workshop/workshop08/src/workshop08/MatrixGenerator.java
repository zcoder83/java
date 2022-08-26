package workshop08;

import java.util.Random;

public class MatrixGenerator {
	// generate matrix function
	public static double[][] generateMatrix(int rows, int columns) {

		double[][] result = new double[rows][columns];

		Random random = new Random();

		// assign random value in the array
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {

				result[i][j] = random.nextDouble(100) * 10;

			}
		}
		return result;
	}
}
