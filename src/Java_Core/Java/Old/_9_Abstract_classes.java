package Java_Core.Java.Old;

abstract class parent
{
    public parent()
    {
        System.out.println("Hi I'am a Parent Constructor");
    }
    public void sayHello()
    {
        System.out.println("hello...");
    }
    abstract public void greet();
}

class Child extends parent{
    public void greet(){
        System.out.println("Good Morning");
    }
}

//When we inherit the abstract class to another class we should either override or make that class as abstract.
abstract class child2 extends parent{
    public void nam(){
        System.out.println("Namste");
    }
}
//OR
//class child2 extends parent{
//    public void greet(){
//        System.out.println("Namste");
//    }
//}

public class _9_Abstract_classes
{
    public static void main(String[] args)
    {
        child c = new child();//can be done.
//        parent p =new parent();--can not be done.
//        child p = new parent();--can not be done.
    }
}
