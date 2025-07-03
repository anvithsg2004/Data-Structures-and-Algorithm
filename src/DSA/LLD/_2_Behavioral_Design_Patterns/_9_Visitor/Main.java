package DSA.LLD._2_Behavioral_Design_Patterns._9_Visitor;

public class Main {
    public static void main(String[] args) {
        Item book = new Book(100);
        Item shirt = new Shirt(200);

        Visitor taxVisitor = new TaxVisitor();

        book.accept(taxVisitor);  // Book tax
        shirt.accept(taxVisitor); // Shirt tax
    }
}
