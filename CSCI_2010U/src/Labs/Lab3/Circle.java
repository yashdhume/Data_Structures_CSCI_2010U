package Labs.Lab3;

public class Circle extends Shape{
    private  float radius;
    final double pi = Math.PI;


    public Circle(String color, float radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return (pi *(radius*radius));
    }

    public double getPerimeter() {
        return (2 * pi * radius);
    }
    @Override
    public String toString(){
        return (color+ " Circle with the Radius " + radius);
    }
}
