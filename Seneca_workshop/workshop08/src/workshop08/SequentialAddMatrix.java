package workshop08;

import java.util.Date;

public class SequentialAddMatrix {

	public static void main(String[] args) {
		Date start = new Date();
		int size = 2000;
		double[][] m1 = MatrixGenerator.generateMatrix(size, size);
		double[][] m2 = MatrixGenerator.generateMatrix(size, size);

		double[][] result = sequentialAddMatrix(m1, m2);

		Date end = new Date();
		System.out.println("sequentialAddMatrix took in milli seconds: " + (end.getTime() - start.getTime()));

	}

	public static double[][] sequentialAddMatrix(double[][] m1, double[][] m2) {
		int resultRows = m1.length;
		int resultColumns = m2[0].length;

		double[][] result = new double[resultRows][resultColumns];

		int columns2 = m2[0].length;

		for (int i = 0; i < resultRows; i++) {
			for (int j = 0; j < columns2; j++) {
				result[i][j] = 0;
				for (int k = 0; k < resultColumns; k++) {
					result[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}

		return result;

	}
}