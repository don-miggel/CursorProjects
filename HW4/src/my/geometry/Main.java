package my.geometry;

import my.geometry.shapes.*;
import my.geometry.vertices.Vertex;
import my.geometry.vertices.Vertex3D;

public class Main {
    public static void main(String[] args) {

        System.out.println("-------CIRCLE DEMO---------------");
        Shape circle1 = new Circle(new Vertex(5, 4), 3.5);
        System.out.println("Circle area: " + ((Circle) circle1).getArea());
        System.out.println("Circle perimeter: " + ((Circle) circle1).getPerimeter());
        System.out.println(circle1);

        System.out.println("-------RECTANGLE DEMO---------------");
        Shape rect1 = new Rectangle(new Vertex(0, 2), 8.2, 10.5);
        System.out.println("Rectangle area: " + ((Rectangle) rect1).getArea());
        System.out.println("Rectangle perimeter: " + ((Rectangle) rect1).getPerimeter());
        System.out.println(rect1);

        System.out.println("-------TRIANGLES DEMO---------------");
        Shape triag1 = new Triangle(new Vertex(3, 2), new Vertex(1, 0), new Vertex(0, -1));
        System.out.println(triag1);
        System.out.println("Triangle1 perimeter: " + ((Triangle) triag1).getPerimeter());
        System.out.println("Triangle1 area: " + ((Triangle) triag1).getArea());
        Shape triag2 = new Triangle(new Vertex(2, 2), new Vertex(4, 6), new Vertex(5, 2));
        System.out.println(triag2);
        System.out.println("Triangle2 perimeter: " + ((Triangle) triag2).getPerimeter());
        System.out.println("Triangle2 area: " + ((Triangle) triag2).getArea());

        System.out.println("-------SPHERE DEMO---------------");
        Shape sphere1 = new Sphere(new Vertex3D(1, 3, 5), 5.5);
        System.out.println(sphere1);
        System.out.println("Sphere area: " + ((Sphere) sphere1).getArea());
        System.out.println("Sphere volume: " + ((Sphere) sphere1).getVolume());

        System.out.println("-------CUBOID DEMO---------------");
        Shape cubo1 = new Cuboid(new Vertex3D(1, 2, -3), 4, 5, 6);
        System.out.println(cubo1);
        System.out.println("Cuboid area: " + ((Cuboid) cubo1).getArea());
        System.out.println("Cuboid volume: " + ((Cuboid) cubo1).getVolume());

        System.out.println("-------SQUARE PYRAMID DEMO---------------");
        Shape sqPyr1 = new SquarePyramid(new Vertex3D(5, 3, -2), 22.5, 7.8);
        System.out.println(sqPyr1);
        System.out.println("Square pyramid area: " + ((SquarePyramid) sqPyr1).getArea());
        System.out.println("Square pyramid volume: : " + ((SquarePyramid) sqPyr1).getVolume());

        //Loop through all the shapes in the loop
        Shape[] mySpapes = {sqPyr1, circle1, triag1, sphere1, triag2, rect1, cubo1};
        for (Shape shape : mySpapes)
            System.out.println(shape.getClass().getName() + ": " + " \n" + shape);

    }
}
