package DSA.Recursion.Kunal_Kushwaha.Introduction;

public class _8_Reverse_An_Digit {

    public static int reverse(int num, int reversed) {

        if (num == 0) {
            return reversed;
        }

        reversed = (reversed * 10) + (num % 10);
        return reverse(num / 10, reversed);

    }

    public static void main(String[] args) {

    }
}
