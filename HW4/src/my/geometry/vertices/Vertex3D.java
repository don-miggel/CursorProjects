package my.geometry.vertices;

public class Vertex3D extends Vertex {

    private double z;

    public Vertex3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return super.toString().replace("Vertex", "Vertex3D").replace('}', ',') +
                " z=" + z +
                '}';
    }
}
