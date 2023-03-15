package my.geometry.shapes;

import my.geometry.vertices.Vertex3D;

public class Sphere extends SpaceShape {

    private double radius;

    public Sphere(Vertex3D center, double radius) {
        super(center);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return 4 * Math.PI * radius * radius;
    }

    public double getVolume() {
        return (double) 4 / 3 * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "radius=" + radius +
                ", sphere center=" + super.toString() +
                super.getAreaAndVolume() +
                '}';
    }
}
