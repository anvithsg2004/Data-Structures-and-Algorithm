package DSA.Patterns;

public class _6 {

    public static void print(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= (n-i+1); j++) {
                System.out.println(j);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        print(n);
    }
}
