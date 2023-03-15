package my.geometry.shapes;

import my.geometry.vertices.Vertex3D;

import java.util.Arrays;

public class SquarePyramid extends SpaceShape {

    private double width;
    private double height;

    public SquarePyramid(Vertex3D baseCenter, double width, double height) {
        super(baseCenter);
        this.width = width;
        this.height = height;

    }

    public double getArea() {
        double slantHeight = Math.sqrt(Math.pow(height, 2) + Math.pow(width / 2, 2));
        double oneTriangleSquare = 0.5 * slantHeight * width;
        return 4 * oneTriangleSquare;
    }


    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    private double calcBaseArea() {
        return width * width;
    }

    public double getVolume() {
        return calcBaseArea() * height / 3;
    }

    @Override
    public String toString() {
        return "SquarePyramid{" +
                "width=" + width +
                ", height=" + height +
                ", base center=" + super.toString() +
                super.getAreaAndVolume() +
                '}';
    }
}
