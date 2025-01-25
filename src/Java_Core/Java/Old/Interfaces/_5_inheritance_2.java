package Java_Core.Java.Old.Interfaces;

class base{
    int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        System.out.println("I am setting a X now...");
        this.x = x;
    }

    public void printme(){
        System.out.println("I am a constructor");
    }
}

class derived extends base{

    int y;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

public class _5_inheritance_2 {
    public static void main(String[] args) {
    base b =new base();
    b.setX(5);
    System.out.println(b.getX());
    }
}
