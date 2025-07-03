package DSA.LLD._5_Highest_Asked_Design_Patterns._2_Factory_Pattern;


//Shape is a type (interface).
//
//Circle and Rectangle are real objects that follow the Shape rules.
//
//Java allows returning an interface if the object implements it.
//
//This makes your code flexible and clean.


interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType == null) return null;

        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle(); // Circle implements Shape
        }

        if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle(); // Rectangle implements Shape
        }

        return null;
    }
}

public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();  // Output: Drawing a Circle

        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw();  // Output: Drawing a Rectangle
    }
}

