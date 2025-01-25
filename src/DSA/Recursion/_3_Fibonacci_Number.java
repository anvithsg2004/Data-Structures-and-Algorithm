package DSA.Recursion;

public class _3_Fibonacci_Number {

    public int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        int last = fibonacci(n - 1);
        int secondLast = fibonacci(n - 2);

        return last + secondLast;
    }

    public static void main(String[] args) {

    }
}
