package workshop08;
// create a Thread class that implements Runnable Interface.
public class MultiplyThread implements Runnable {

	private final double[][] result;
	private double[][] m1;
	private double[][] m2;
	private final int row;

	public MultiplyThread(double[][] result, double[][] m1, double[][] m2, int row) {
	  this.result = result;
	  this.m1 = m1;
	  this.m2 = m2;
	  this.row = row;
	 }

	@Override
	public void run() {

		for (int i = 0; i < m2[0].length; i++) {
			result[row][i] = 0;
			for (int j = 0; j < m1[row].length; j++) {
				result[row][i] += m1[row][j] * m2[j][i];

			}

		}

	}

}
