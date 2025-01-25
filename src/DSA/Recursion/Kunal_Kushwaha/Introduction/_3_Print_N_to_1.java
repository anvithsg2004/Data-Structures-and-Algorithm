package DSA.Recursion.Kunal_Kushwaha.Introduction;

public class _3_Print_N_to_1 {

    public static void nto1(int n) {

        if (n == 1) {
            System.out.println(1);
            return;
        }

        System.out.println(n);

        nto1(n - 1);
    }

    public static void main(String[] args) {

        nto1(5);

    }
}
