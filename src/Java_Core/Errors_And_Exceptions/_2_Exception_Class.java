package Java_Core.Errors_And_Exceptions;

import java.util.Scanner;

class MyException extends Exception {

    @Override
    public String toString() {
        return super.toString() + "I am toString()";
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "I am getMessage()";
    }

}


public class _2_Exception_Class {
    public static void main(String[] args) {

        int a;
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();

        if (a < 9) {

            try {
//                throw new MyException();
                throw new ArithmeticException();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.toString());
                //If only e is asked to print, then it will print only e.toString().
                System.out.println(e);
                //This is not an Error.
                e.printStackTrace();
            }

        }

    }
}
