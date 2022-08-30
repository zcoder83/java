/**********************************************
Workshop 03 
Course:Java for C++ Programmers
Last Name: Jeong
First Name: Yeonkwan
ID: 104069208
Section: JAC444ZCC
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 2022-02-21
**********************************************/
package workshop03;
import java.lang.Math;

public class Triangle extends GeometricObject {
	private double side1;
	private double side2;
	private double side3;
	
	// default constructor
	public Triangle() {
		this(1.0, 1.0, 1.0);
	}
	public Triangle(double side1, double side2, double side3) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	// getter
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
