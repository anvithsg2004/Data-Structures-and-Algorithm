package DSA.LLD._5_Highest_Asked_Design_Patterns._3_Builder_Pattern;

class Pizza {
    private String dough;
    private String sauce;
    private String topping;

    // Private constructor (can only be built using Builder)
    private Pizza(PizzaBuilder builder) {
        this.dough = builder.dough;
        this.sauce = builder.sauce;
        this.topping = builder.topping;
    }

    public void display() {
        System.out.println("Pizza with " + dough + ", " + sauce + ", " + topping);
    }

    // Static nested Builder class
    public static class PizzaBuilder {
        private String dough;
        private String sauce;
        private String topping;

        public PizzaBuilder setDough(String dough) {
            this.dough = dough;
            return this;
        }

        public PizzaBuilder setSauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public PizzaBuilder setTopping(String topping) {
            this.topping = topping;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Pizza pizza = new Pizza.PizzaBuilder()
                .setDough("Thin Crust")
                .setSauce("Tomato")
                .setTopping("Cheese")
                .build();

        pizza.display(); // Output: Pizza with Thin Crust, Tomato, Cheese
    }
}
