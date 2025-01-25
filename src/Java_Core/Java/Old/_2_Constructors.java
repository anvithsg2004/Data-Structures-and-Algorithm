package Java_Core.Java.Old;

class Myemployee{
    int id;
    String name;
    int salary;

//    DEFAULT CONSTRUCTOR
    Myemployee(){
        System.out.println("This is a default constructor");
        id=15;
        name="Ramya";
    }

    //or use this type.
//    PARAMETRIZED CONSTRUCTOR
    Myemployee(int i,String s){
        System.out.println("This is a parametrized cinstructor");
        id=i;
        name=s;
    }

    public int getId(){
        return id;
    }

    public void setId(int i){
        id = i;
    }

    public String getName(){
        return name;
    }

    public void setName(String n){
        name = n;
    }
}
public class _2_Constructors {
    public static void main(String[] args){
        Myemployee b1 = new Myemployee(5,"Anvith");
//        b1.id = 12;
//        b1.name = "THE KING";
//      We can set like this aslo.
//        b1.setId(5);
        System.out.println(b1.getId());
        System.out.println(b1.getName());
   }
}
