package Java_Core.Java.Old;

import java.util.Scanner;

class Student {

    private String name;
    private int marks;

    public void setDetails(String n, int m) {
        name = n;
        marks = m;
    }

    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
    }

    public int getMarks() {
        return marks;
    }
}

class _14_Array_Objects_loops {

    public static void main(String[] args) {

        System.out.println("Enter the number student :");
        Scanner d = new Scanner(System.in);
        int n = d.nextInt();

        // declaring array of objects
        Student[] st = new Student[n];

        // initializing array
        Scanner s = new Scanner(System.in);

        int i = 0 ;

        for ( i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ":");
            System.out.println("Enter name :");
            String name = s.nextLine();
            System.out.println("Enter marks :");
            int marks = s.nextInt();
            s.nextLine();

            st[i] = new Student();
            st[i].setDetails(name, marks);
        }

        // printing details of the objects
        for ( i = 0; i < n; i++) {
            st[i].printDetails();
        }

        int totalMarks = 0;
        for (i = 0; i < n; i++) {
            totalMarks += st[i].getMarks();
        }
        System.out.println("Total Marks Obtained by Students: " + totalMarks);
    }
}
