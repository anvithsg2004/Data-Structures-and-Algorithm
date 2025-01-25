package DSA.Recursion.Kunal_Kushwaha.Introduction;

public class _4_Print_1_to_N {

    public static void oneTon(int n) {

        if (n == 0) {
            return;
        }

        oneTon(n - 1);
        System.out.println(n);

    }

    public static void main(String[] args) {

        oneTon(5);

    }
}
