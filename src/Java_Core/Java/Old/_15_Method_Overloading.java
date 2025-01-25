package Java_Core.Java.Old;

class casio{
    public void add(int a){
        System.out.println(a);
    }
    public void add(int a,int b){
        System.out.println(a+b);
    }
}

public class _15_Method_Overloading {
    public static void main(String[] args) {
        casio c = new casio();
        c.add(5,6);
        c.add(8);
    }
}
