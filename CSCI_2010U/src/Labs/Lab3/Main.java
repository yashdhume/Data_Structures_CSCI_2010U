package Labs.Lab3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle("Red", 2.0f));
        shapes.add(new Rectangle("Blue", 1.5f, 3.0f));
        for (Shape shape : shapes) {
            System.out.println("");
            System.out.println(shape.toString());
            System.out.printf("Area:     %.2f\n", shape.getArea());
            System.out.printf("Perimeter: %.2f\n", shape.getPerimeter());
        }
    }
}
