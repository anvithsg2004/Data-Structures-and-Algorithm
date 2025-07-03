package DSA.LLD._3_Structural_Design_Patterns._4_Decorator_Design_Pattern;

interface Coffee {
    String getDescription();

    double getCost();
}

class SimpleCoffee implements Coffee {
    public String getDescription() {
        return "Simple Coffee";
    }

    public double getCost() {
        return 5.0;
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public String getDescription() {
        return coffee.getDescription();
    }

    public double getCost() {
        return coffee.getCost();
    }
}

class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return super.getDescription() + ", Milk";
    }

    public double getCost() {
        return super.getCost() + 1.5;
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return super.getDescription() + ", Sugar";
    }

    public double getCost() {
        return super.getCost() + 0.5;
    }
}

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee(); // base

        coffee = new MilkDecorator(coffee);  // add milk
        coffee = new SugarDecorator(coffee); // add sugar

        System.out.println(coffee.getDescription()); // Simple Coffee, Milk, Sugar
        System.out.println("Total Cost: " + coffee.getCost()); // 7.0
    }
}
