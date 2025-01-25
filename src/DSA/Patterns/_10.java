package DSA.Patterns;

public class _10 {

    public static void print(int n) {
        for (int i = 1; i <= (2*n)-1; i++) {
            int stars = i;
            if (i > n) {
                stars = (2*n) - i;
            }

            for (int j = 1; j <= stars; j++) {
                System.out.println("*");
            }
            System.out.println();

        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 5;
        print(n);
    }
}
