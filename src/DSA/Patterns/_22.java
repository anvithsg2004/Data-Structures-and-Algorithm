package DSA.Patterns;

public class _22 {

    public static void print(int n) {
        for (int i = 0; i < (2*n)-1; i++) {
            for (int j = 0; j < (2*n)-1; j++) {
                int top = i;
                int left = j;
                int right = (((2*n)-1)-1)-j;
                int bottom = (((2*n)-1)-1)-i;

                System.out.println(n - Math.min(Math.min(top,bottom),Math.min(left,right)));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        print(n);
    }
}
