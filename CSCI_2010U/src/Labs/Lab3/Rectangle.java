package Labs.Lab3;

public class Rectangle extends Shape{
    private  float width, length;


    public Rectangle( String color, float width, float length) {
        super (color);
        this.width = width;
        this.length = length;
    }

    @Override
    public double getArea() {
        return (width * length);
    }

    @Override
    public double getPerimeter() {
        return (2 * (width + length));
    }
    @Override
    public String toString(){
        return (color+ " Rectangle with the length " + length + " and width " + width);
    }

}
