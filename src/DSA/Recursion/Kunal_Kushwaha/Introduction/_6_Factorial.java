package DSA.Recursion.Kunal_Kushwaha.Introduction;

public class _6_Factorial {

    public static long factorial(int n) {

        if (n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    public static void main(String[] args) {

        long n = 5;
        System.out.println(factorial(20));

    }
}
