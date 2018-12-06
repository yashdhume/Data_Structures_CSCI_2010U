package Labs.Lab3;

public abstract class Shape {
    public abstract double getArea();
    public abstract double  getPerimeter();
    public abstract  String toString();
    protected String color;

    public Shape(String color) {
        this.color = color;
    }
}
