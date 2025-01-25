package Java_Core.Java.Old;

class animal {

    // field and method of the parent class
    String name;
    public void eat() {
        System.out.println("I can eat");
    }
}

// inherit from Animal
class dog extends animal {

    // new method in subclass
    public void display() {
        System.out.println("My name is " + name);
    }
}

public class _4_inheritance_example {
    public static void main(String[] args) {

        // create an object of the subclass
        dog labrador = new dog();

        // access field of superclass
        labrador.name = "Rohu";
        labrador.display();

        // call method of superclass
        // using object of subclass
        labrador.eat();

    }
}
