package DSA.Patterns;

public class _12 {

    public static void print(int n) {
        int space = 2 * (n - 1);
        for (int i = 1; i <= n; i++) {
            //Number
            for (int j = 1; j <=i; j++) {
                System.out.println(j);
            }

            //Space
            for (int j = 1; j <= space; j++)
                System.out.println(" ");

            //Number
            for (int j = i; j >= 1; j--) {
                System.out.println(j);
            }

            System.out.println();
            space = space - 2;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        print(n);
    }
}
