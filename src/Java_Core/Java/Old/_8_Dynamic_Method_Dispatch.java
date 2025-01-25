package Java_Core.Java.Old;/* This is dynamic method dispatch or runtime polymorphism */

class Phone{
    public void on(){
        System.out.println("The phone is turning on...");
    }

    public void greet(){
        System.out.println("I greeet u...");
    }
}

class SmartPhone extends Phone{
    public void on(){
        System.out.println("The Smartphone is turning on...");
    }

    public void namste(){
        System.out.println("I namste to u...");
    }
}

public class _8_Dynamic_Method_Dispatch {
    public static void main(String[] args) {
        Phone obj = new SmartPhone();
        obj.on();
        obj.greet();
    }
}
