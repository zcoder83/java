package workshop03;
import java.util.*;
public class TriangleDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter three sides: ");
		double side1 = scan.nextDouble();
		double side2 = scan.nextDouble();
		double side3 = scan.nextDouble();
		System.out.print("Enter the color: ");
		String color = scan.next();
		System.out.print("Enter true or false for filled: ");
		Boolean filled = scan.nextBoolean();
		
		Triangle triangle = new Triangle(side1, side2, side3);
		triangle.setColor(color);
		triangle.setFilled(filled);
		
		System.out.println(triangle.toString());
		System.out.println("Area: " + triangle.getArea());
		System.out.println("Periment: " + triangle.getPerimeter());
		System.out.println("Color: " + triangle.getColor());
		System.out.println("Filled: " + triangle.getFilled());
	}
}
