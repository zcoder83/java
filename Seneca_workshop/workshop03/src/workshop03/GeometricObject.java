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

abstract class GeometricObject {
	private String color = "white";
	private Boolean filled;
	public GeometricObject(){
		
	}
	public GeometricObject(String color, boolean filled) {
		this.color = color;
		this.filled = filled;
	}
	
	//getter and setter
	String getColor() {
		return color;
	}
	void setColor(String color) {
		this.color = color;
	}
	Boolean getFilled() {
		return filled;
	}
	void setFilled(Boolean filled) {
		this.filled = filled;
	}
	abstract double getArea();
	abstract double getPerimeter();
}
