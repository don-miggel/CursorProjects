package my.geometry.shapes;

import my.geometry.interfaces.AreaMeasurable;
import my.geometry.interfaces.PerimeterMeasurable;
import my.geometry.vertices.Vertex;

import java.util.Arrays;

public abstract class PlaneShape extends Shape implements AreaMeasurable, PerimeterMeasurable {

    PlaneShape(Vertex... vertices) {
        super(vertices);
    }

    public String getAreaAndPerimeter() {
        return ", area=" + getArea() +
                ", volume =" + getPerimeter();
    }

}
