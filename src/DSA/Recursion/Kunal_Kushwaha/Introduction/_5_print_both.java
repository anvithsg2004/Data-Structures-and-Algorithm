package DSA.Recursion.Kunal_Kushwaha.Introduction;

public class _5_print_both {

    public static void both(int n) {
        if (n == 0) {
            return;
        }

        System.out.println(n);
        both(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {

        both(5);

    }
}
