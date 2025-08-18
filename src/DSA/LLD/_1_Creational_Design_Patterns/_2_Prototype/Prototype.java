package DSA.LLD._1_Creational_Design_Patterns._2_Prototype;

public class Prototype implements Cloneable {

    private String data;

    public Prototype(String data) {
        this.data = data;
    }

    public void showData() {
        System.out.println("Data: " + data);
    }

    @Override
    public Prototype clone() {
        try {
            return (Prototype) super.clone(); // Shallow copy
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
