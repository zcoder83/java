package workshop08;
import java.util.Date;
import java.util.ArrayList;

public class ParallelAddMatrix {
	public static void main(String[] args) {

		Date start = new Date();

		double[][] m1 = MatrixGenerator.generateMatrix(2000, 2000);
		double[][] m2 = MatrixGenerator.generateMatrix(2000, 2000);

		double[][] result = new double[m1.length][m2[0].length];
		parallelAddMatrix(m1, m2, result);

		Date end = new Date();
		System.out.println("parallelAddMatrix took in milli seconds: " + (end.getTime() - start.getTime()));

	}

	// parallel matrix
	public static void parallelAddMatrix(double[][] m1, double[][] m2, double[][] result) {
		ArrayList<Thread> threads = new ArrayList<>();
		int rows1 = m1.length;
		for (int i = 0; i < rows1; i++) {
			MultiplyThread task = new MultiplyThread(result, m1, m2, i);
			Thread thread = new Thread(task);
			thread.start();
			threads.add(thread);
			if (threads.size() % 4 == 0) {
				waitForThreads(threads);
			}
		}
	}

	private static void waitForThreads(ArrayList<Thread> threads) {
		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		threads.clear();
	}
}