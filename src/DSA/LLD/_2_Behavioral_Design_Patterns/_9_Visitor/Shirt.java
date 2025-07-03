package DSA.LLD._2_Behavioral_Design_Patterns._9_Visitor;

public class Shirt implements Item {
    int price;

    public Shirt(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
