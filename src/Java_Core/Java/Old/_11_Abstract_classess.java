package Java_Core.Java.Old;

abstract class Parent2{
    public Parent2(){
        System.out.println("Mai base2 ka constructor hoon");
    }
    public void sayHello(){
        System.out.println("Hello");
    }
    abstract public void greet();
    abstract public void greet2();
}

class Child5 extends Parent2{
    @Override
    public void greet(){
        System.out.println("Good morning");
    }
    @Override
    public void greet2(){
        System.out.println("Good afternoon");
    }
}

abstract class Child3 extends Parent2{
    public void th(){
        System.out.println("I am good");
    }
}
public class _11_Abstract_classess {
    public static void main(String[] args) {
        //Parent2 p = new Parent2(); -- error
        Child5 c = new Child5();
        //Child3 c3 = new Child3(); -- error
    }
}
