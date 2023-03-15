package my.geometry.shapes;

import my.geometry.vertices.Vertex;

import java.util.Arrays;

public class Shape {

    Vertex[] vertices;

    Shape(Vertex...vertices){
        this.vertices = vertices.clone();
    }

    public String toString() {
        return Arrays.toString(vertices);
    }



}
