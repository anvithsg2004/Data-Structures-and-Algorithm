package Java_Core.Java.Old;

class Base1{
    int x;

    Base1(){
        System.out.println("I am a contructor");
    }

    Base1(int a){
        System.out.println("I am overloaded constructor in base class " + a);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}

class Derived1 extends Base1{
    int y;

    Derived1(){
        super(0);
        System.out.println("I am a derived class contructor");
    }

    Derived1(int a,int b){
        super(a);
        System.out.println("I am overloaded constructor in base class " + b);
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

class child extends Derived1{

    child(){
        System.out.println("I am a child of derived class contructor");
    }

    child(int a,int b,int c){
        super(a,b);
        System.out.println("I am overloaded constructor in base class " + c);
    }

}

public class _5_inheritance_contructor {
    public static void main(String[] args){
//        Base1 b = new Base1();
//        Derived1 d = new Derived1();
       Derived1 d = new Derived1(14,8);
//        child cd = new child();
//        child cd = new child(5,5,8);
    }
}
