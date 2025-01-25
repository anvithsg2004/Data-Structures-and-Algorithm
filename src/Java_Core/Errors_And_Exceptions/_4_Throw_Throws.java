package Java_Core.Errors_And_Exceptions;

// throw is used to trigger an exception, while throws is used to declare that a method can throw exceptions.
// throw is used inside a method, while throws is part of the method signature.

public class _4_Throw_Throws {

    public static int divide(int a, int b) throws ArithmeticException {

        int c = a / b;

        return c;

    }

    //We can use multiple "throws" while defining the method
    //Example :-
    //public void myMethod() throws IOException, SQLException, NullPointerException {
    //// Code that might throw any of these exceptions
    //}


    public static void main(String[] args) {

        int a = 2;
        int b = 0;

        //If in the function there is mentioned any Exception is there then, use try-catch block.
        try {

            int c = divide(a, b);
            System.out.println(c);

        } catch (Exception e) {

            System.out.println("Exception is there.");

        }

    }
}

//The return type is only applied on the try block, not on the catch and finally block.
