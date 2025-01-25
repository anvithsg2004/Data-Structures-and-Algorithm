package DSA.Patterns;

public class _1 {

    public static void print(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        print(n);
    }
}