package my.geometry.shapes;

import my.geometry.vertices.Vertex3D;

import java.util.Arrays;

public class Cuboid extends SpaceShape {

    private double width;
    private double height;
    private double depth;


    public Cuboid(Vertex3D point, double width, double height, double depth) {
        super(point);
        this.width = width;
        this.height = height;
        this.depth = depth;
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

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    @Override
    public double getArea() {
        return 2 * (depth * width + width * height + depth * height);
    }

    @Override
    public double getVolume() {
        return width * height * depth;
    }

    @Override
    public String toString() {
        return "Cuboid{" +
                "width=" + width +
                ", height=" + height +
                ", depth=" + depth +
                ", point=" + Arrays.toString(vertices) +
                super.getAreaAndVolume() +
                '}';
    }
}
