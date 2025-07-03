package DSA.LLD._2_Behavioral_Design_Patterns._9_Visitor;

public class TaxVisitor implements Visitor {
    public void visit(Book book) {
        System.out.println("Book tax: " + (book.getPrice() * 0.05));
    }

    public void visit(Shirt shirt) {
        System.out.println("Shirt tax: " + (shirt.getPrice() * 0.10));
    }
}
