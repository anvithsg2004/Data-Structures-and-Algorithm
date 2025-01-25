package DSA.Patterns;

public class _8 {

    public static void print(int n) {
        for (int i = 0; i < n; i++) {
            //Space
            for (int j = 0; j < i; j++) {
                System.out.println(" ");
            }
            //Star
            for (int j = 0; j < (2*n - ((2*i) + 1)); j++) {
                System.out.println("*");
            }
            //Space
            for (int j = 0; j < i; j++) {
                System.out.println(" ");
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        print(n);
    }
}
