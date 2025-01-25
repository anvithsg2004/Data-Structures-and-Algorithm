package Java_Core.Java_8.Method_and_Constructor_References;

public class student {

    String name;

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                '}';
    }

    public student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
