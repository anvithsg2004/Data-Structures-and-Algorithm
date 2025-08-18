package DSA.LLD._1_Creational_Design_Patterns._3_Builder;

public class Product {
    private String name;
    private double price;
    private String description;

    // Private constructor so only Builder can create it
    private Product(Builder builder) {
        this.name = builder.name;
        this.price = builder.price;
        this.description = builder.description;
    }

    public void showProduct() {
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Description: " + description);
    }

    // Static Builder class
    public static class Builder {
        private String name;
        private double price;
        private String description;

        public Builder setName(String name) {
            this.name = name;
            return this; // return Builder for chaining
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
