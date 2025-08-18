package DSA.LLD._1_Creational_Design_Patterns._5_AbstractFactory;

class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("shape")) return new ShapeFactory();
        if (choice.equalsIgnoreCase("color")) return new ColorFactory();
        return null;
    }
}
