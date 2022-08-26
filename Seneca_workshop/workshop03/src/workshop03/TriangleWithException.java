
package workshop03;
import java.lang.Math;

public class TriangleWithException extends GeometricObject {
	private double side1 = 1.0;
	private double side2 = 1.0;
	private double side3 = 1.0;
	
	public TriangleWithException() {
		
	}
	public TriangleWithException(double side1, double side2, double side3) throws TriangleException {
		if (side1 > side2 + side3)
	        throw new TriangleException(side1);
	    else if (side2 > side1 + side3)
	        throw new TriangleException(side2);
	    else if (side3 > side2 + side1)
	        throw new TriangleException(side3);
	    else {
	        this.side1 = side1;
	        this.side2 = side2;
	        this.side3 = side3;
	    }
	}
	
	//getter
	public double getSide1() {
		return side1;
	}
	public double getSide2() {
		return side2;
	}
	public double getSide3() {
		return side3;
	}
	
	public double getArea() {
		double s = (side1 + side2 + side3) / 2;
		return Math.sqrt(s * (s-side1) * (s-side2) * (s-side3));
	}
	
	public double getPerimeter() {
		return side1 + side2 + side3;
	}
	
	public String toString() {
		return "Triangle has " + side1 + ", " + side2 + ", " + side3 + " sides";
	}
}
