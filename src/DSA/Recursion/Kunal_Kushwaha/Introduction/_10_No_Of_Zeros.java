package DSA.Recursion.Kunal_Kushwaha.Introduction;

public class _10_No_Of_Zeros {

    public static int noOfZeros(int num) {

        if (num == 0) {
            return 0;
        }

        int reminder = num % 10;

        return (reminder == 0 ? 1 : 0) + noOfZeros(num / 10);

    }

    public static int NoOfZeros(int num) {

        if (num == 0) {
            return 1;
        }

        return noOfZeros(num);

    }

    public static void main(String[] args) {

    }
}
