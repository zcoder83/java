package com.Class;

import java.awt.*;

public class Circle {
    Point point;
    double radius;

    Circle (){}
    Circle (Point point, double radius) {
        this.point = point;
        this.radius = radius;
    }
    public double getRadius() {
        return this.radius;
    }
}
