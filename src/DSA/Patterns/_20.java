package DSA.Patterns;

public class _20 {
    public static void print(int n) {
        int space2 = 8;
        for (int i = 0; i <n; i++) {
            //Stars
            for (int j = 1; j <= n; j++) {
                System.out.println("*");
            }
            //Space
            for (int j = 0; j < space2; j++) {
                System.out.println(" ");
            }
            //Stars
            for (int j = 1; j <= n; j++) {
                System.out.println("*");
            }

            space2 = space2 - 2;
            System.out.println();
        }

        int space = 0;
        for (int i = 0; i <n; i++) {
            //Stars
            for (int j = 1; j <= n-i; j++) {
                System.out.println("*");
            }
            //Space
            for (int j = 0; j < space; j++) {
                System.out.println(" ");
            }
            //Stars
            for (int j = 1; j <= n-i; j++) {
                System.out.println("*");
            }

            space = space + 2;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        print(n);
    }
}
