package DSA.Patterns;

public class _14 {

    public static void print(int n) {
        for (int i =0; i < n; i++) {
            for (char ch = 'A'; ch <= 'A' + i; ch++) {
                System.out.println(ch);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
    int n = 5;
    print(n);
    }
}
