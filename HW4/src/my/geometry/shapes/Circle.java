package my.geometry.shapes;

import my.geometry.vertices.Vertex;

import java.util.Arrays;

public class Circle extends PlaneShape {

    private double radius;

    public Circle(Vertex point, double radius) {
        super(point);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return 2 * Math.PI * Math.pow(radius, 2);
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", center=" + super.toString() +
                super.getAreaAndPerimeter() +
                '}';
    }
}
