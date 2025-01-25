package Java_Core.Java.Old;

class base{
    int x;

    public void printme(){
        System.out.println("I'm a constructor");
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
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

public class _3_Inheritance {
    public static void main(String[] args){

        derived b2 = new derived();
//        b2.x=15;
//        b2.y=25;
        b2.setX(15);
        b2.setY(68);
        System.out.println(b2.getX());
        System.out.println(b2.getY());
    }
}
