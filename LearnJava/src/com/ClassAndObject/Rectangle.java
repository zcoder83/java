package com.ClassAndObject;

public class Rectangle {
    private double width;
    private double height;

    public Rectangle () {
        this(1.0, 1.0);
    }
    public Rectangle (double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea () {
        return width * height;
    }

    public double getPerimeter () {
        return (width + height) * 2;
    }

    public double getWidth () {
        return width;
    }
    public void setWidth (double width) {
        this.width = width;
    }
    public double getHeight () {
        return height;
    }
    public void setHeight (double height) {
        this.height = height;
    }

}
