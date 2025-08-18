package DSA.LLD._1_Creational_Design_Patterns._3_Builder;

public class Main {
    public static void main(String[] args) {
        Product product = new Product.Builder()
                .setName("Laptop")
                .setPrice(999.99)
                .setDescription("High performance laptop")
                .build();

        product.showProduct();
    }
}
