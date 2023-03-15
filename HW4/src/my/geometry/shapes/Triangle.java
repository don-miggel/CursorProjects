package my.geometry.shapes;

import my.geometry.vertices.Vertex;

import java.util.Arrays;

public class Triangle extends PlaneShape {

    public Triangle(Vertex A, Vertex B, Vertex C) {
        super(A, B, C);
    }

    // find distance between two points to find area and/or perimeter of the triangle
    private double findDistance(Vertex X1, Vertex X2) {
        // d = √((x2 - x1)2 + (y2 - y1)2)
        return Math.sqrt(Math.pow((X2.getX() - X1.getX()), 2) + Math.pow((X2.getY() - X1.getY()), 2));
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "points=" + super.toString() +
                super.getAreaAndPerimeter() +
                '}';
    }

    public double getArea() {

        double halfPerimeter = getPerimeter() / 2;
        double oppositeA = findDistance(vertices[1], vertices[2]);
        double oppositeB = findDistance(vertices[0], vertices[2]);
        double oppositeC = findDistance(vertices[1], vertices[2]);
        return Math.sqrt(halfPerimeter * (halfPerimeter - oppositeA) * (halfPerimeter - oppositeB) *
                (halfPerimeter - oppositeC));
    }


    public double getPerimeter() {
        return findDistance(vertices[0], vertices[1]) + findDistance(vertices[1], vertices[2]) +
                findDistance(vertices[0], vertices[2]);
    }
}
