package workshop03;

public class TriangleException extends Exception {
	public TriangleException (double side) {
		super(side + " is bigger than the sum of other two sides");
	}
	
}
