package Java_Core.Java.Old;

class MyClass {
    private int value;

    public MyClass(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}


public class _12_Array_Objects {
    public static void main(String[] args) {
        int n = 5; // Number of objects you want in the array
        MyClass[] myArray = new MyClass[n]; // Create an array of MyClass objects

        // Initialize each element of the array
        for (int i = 0; i < n; i++) {
            myArray[i] = new MyClass(i); // Creating a new MyClass object and assigning it to the array
        }

        // Access and use the objects in the array
        for (int i = 0; i < n; i++) {
            System.out.println("Element " + i + ": " + myArray[i].getValue());
        }
    }
}
