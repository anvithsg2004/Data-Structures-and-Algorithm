package DSA.LLD._5_Highest_Asked_Design_Patterns._2_Factory_Pattern;

interface Animal {
    void makeSound();
}

class Dog implements Animal {
    public void makeSound() {
        System.out.println("Woof!");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a = new Dog();  // Dog object, stored in Animal reference
        a.makeSound();         // Output: Woof!
    }
}
