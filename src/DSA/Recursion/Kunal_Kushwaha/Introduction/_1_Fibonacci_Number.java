package DSA.Recursion.Kunal_Kushwaha.Introduction;

public class _1_Fibonacci_Number {

    public static int fib(int n) {

        if (n < 2) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {

        int ans = fib(6);
        System.out.println(ans);

    }
}
