package Java_Core.Errors_And_Exceptions;

public class _1_Try_Catch_Block {
    public static void main(String[] args) {

        int a = 600;
        int b = 0;

        try {

            int c = a/b;

            System.out.println("Result is " + c);

        } catch (Exception e) {

            System.out.println(e.toString());

        }

    }
}
