package Java_Core.Java.Old;

class vivo{
    int id;
    String name;
    public vivo(int a){
        id = a;
        System.out.println("The number is :" + a);
    }
    public vivo(int a,int b){
        id = a+b;
        System.out.println("The numbers are :" + a + "and " + b);
    }
    public vivo(String a,String b){
        name = b;
        System.out.println("The names are :" + a + " and " + b);
    }
}

public class _16_Constructor_Overloading {
    public static void main(String[] args) {
        vivo a = new vivo(5);
        System.out.println("The id is " + a.id);
        vivo b = new vivo(9,8);
        System.out.println("The id is "+ b.id);
        vivo c = new vivo("Anvith S G","Sumathi K S");
        System.out.println("The name is " + c.name );
    }
}
