package Java_Core.Java.Old;

class A{
    int a;

    public void meth1(){
        System.out.println("This is a method 1");
    }

    public void meth2(){
        System.out.println("This is a method 2");
    }
}

class B extends A{

    public void meth2(){
        System.out.println("This ia a method 2 of B");
    }

    public void meth3(){
        System.out.println("This is a method 3");
    }
}

public class _6_method_overriding {
    public static void main(String[] args) {
        A a = new A();
        a.meth2();
        B b = new B();
        b.meth2();
    }
}
