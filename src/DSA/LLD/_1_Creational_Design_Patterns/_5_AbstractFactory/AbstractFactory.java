package DSA.LLD._1_Creational_Design_Patterns._5_AbstractFactory;

// ===== Interfaces =====
interface Shape {
    void draw();
}

interface Color {
    void fill();
}

// ===== Shape Implementations =====
class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

// ===== Color Implementations =====
class Red implements Color {
    public void fill() {
        System.out.println("Filling with Red");
    }
}

class Blue implements Color {
    public void fill() {
        System.out.println("Filling with Blue");
    }
}

// ===== Abstract Factory =====
interface AbstractFactory {
    Shape getShape(String shapeType);
    Color getColor(String colorType);
}

// ===== Shape Factory =====
class ShapeFactory implements AbstractFactory {
    public Shape getShape(String shapeType) {
        if (shapeType == null) return null;
        if (shapeType.equalsIgnoreCase("circle")) return new Circle();
        if (shapeType.equalsIgnoreCase("rectangle")) return new Rectangle();
        return null;
    }
    public Color getColor(String colorType) {
        return null; // Not responsible for colors
    }
}

// ===== Color Factory =====
class ColorFactory implements AbstractFactory {
    public Shape getShape(String shapeType) {
        return null; // Not responsible for shapes
    }
    public Color getColor(String colorType) {
        if (colorType == null) return null;
        if (colorType.equalsIgnoreCase("red")) return new Red();
        if (colorType.equalsIgnoreCase("blue")) return new Blue();
        return null;
    }
}
