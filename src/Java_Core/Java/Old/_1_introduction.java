package Java_Core.Java.Old;

import org.w3c.dom.Node;

class employee{
    int id;
    String name;
    int salary;
    Node next;

    //Creating a methods
    public void emplyoeeDetailes(){
        System.out.println("My name is "+ name);
        System.out.println("My ID is "+ id);
        System.out.println("My salary is " + salary);
    }

    //creating methods by return
    public int getSalary(){
        return salary;
    }
}
public class _1_introduction {
    public static void main(String[] args){
        //Inisiating a new empolyee object
        employee anvith = new employee();

        //Setting attributes
        anvith.id = 12;
        anvith.name = "Anvith S G";
        anvith.salary = 15000;

        //Printing attributes
        System.out.println(anvith.id);
        System.out.println(anvith.name);


        //Printing a methods
        anvith.emplyoeeDetailes();

        //New method of calling a get function
        int salary = anvith.getSalary();
        System.out.println(salary);

        //This also can be used to call a function.
        anvith.getSalary();
        System.out.println(anvith.getSalary());

    }
}
