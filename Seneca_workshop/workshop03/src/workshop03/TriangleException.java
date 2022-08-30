package workshop03;

// creating specific exception
public class TriangleException extends Exception { // extending other exception is OK, but as convention reason, extend Exception
	public TriangleException (double side) {
		super(side + " is bigger than the sum of other two sides"); // passing error message
	}
	
}
