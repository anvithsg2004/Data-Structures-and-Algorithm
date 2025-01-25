package DSA.Patterns;

public class _21 {

    public static void print(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == n -1) {
                    System.out.println("*");
                }
                else {
                    System.out.println(" ");
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        print(n);
    }
}
