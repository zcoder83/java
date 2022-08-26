
/**********************************************
Workshop 08 
Course:Java for C++ Programmers
Last Name: Jeong
First Name: Yeonkwan
ID: 104069208
Section: JAC444ZCC
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 2022-04-05
**********************************************/
package workshop08;
public class ReverseThread extends Thread {
	//max number of threads
	static final int max = 50;
	//first number of threads
	static final int first = 1;

	//threads counter
	private int counter;
	
	//constructor
	public ReverseThread(int order) {
		this.counter = order;
	}

	public static void main(String[] args) {
		ReverseThread firstThread = new ReverseThread(first);
		firstThread.start();
	}

	@Override
	public void run() {

		try {
			if (counter <= max) {

				startThread(counter++);

			}
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

	}

	private void startThread(int order) throws InterruptedException {
		ReverseThread reverseHelloThread = new ReverseThread(counter);
		reverseHelloThread.start();
		reverseHelloThread.join();
		System.out.println("Hello from Thread! <" + (counter - 1) + ">	");
		
	}
}