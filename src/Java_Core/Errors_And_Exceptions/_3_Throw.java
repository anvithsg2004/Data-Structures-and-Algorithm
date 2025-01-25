package Java_Core.Errors_And_Exceptions;

public class _3_Throw {
    public static void main(String[] args) {

        int a = 5;
        int b = 0;

        if (b == 0) {
            //Throw is used to throw an Exception Explicitly by an programmer.
            throw new ArithmeticException();
        } else {
            System.out.println(a/b);
        }

    }
}
