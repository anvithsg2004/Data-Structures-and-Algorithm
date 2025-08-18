package DSA.LLD._1_Creational_Design_Patterns._2_Prototype;

public class Main {
    public static void main(String[] args) {
        Prototype original = new Prototype("Original Object");
        original.showData();

        Prototype copy = original.clone();
        copy.showData();
    }
}
