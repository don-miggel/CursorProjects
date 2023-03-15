package my.geometry.shapes;

import my.geometry.interfaces.AreaMeasurable;
import my.geometry.interfaces.VolumeMeasurable;
import my.geometry.vertices.Vertex;
import my.geometry.vertices.Vertex3D;

import java.util.Arrays;

public abstract class SpaceShape extends Shape implements AreaMeasurable, VolumeMeasurable {

    SpaceShape(Vertex3D... vertices) {
        super(vertices);
    }


    public String getAreaAndVolume() {
        return ", area=" + getArea() +
                ", volume =" + getVolume();
    }
}
