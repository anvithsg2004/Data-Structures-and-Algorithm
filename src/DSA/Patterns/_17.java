package DSA.Patterns;

public class _17 {
    public static void print(int n) {
        for (int i = 0; i < n; i++) {
            //Space
            for (int j = 0; j < (n-i-1); j++) {
                System.out.println(" ");
            }
            //Alphabet
            char ch = 'A';
            int breakpoint = ((2*i) + 1)/2;
            for (int j = 1; j <= (2*i) + 1; j++) {
                System.out.println(ch);
                if ( j <= breakpoint) {
                    ch++;
                }
                else {
                    ch--;
                }
            }
            //Space
            for (int j = 0; j < (n-i-1); j++) {
                System.out.println(" ");
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        print(n);
    }
}
