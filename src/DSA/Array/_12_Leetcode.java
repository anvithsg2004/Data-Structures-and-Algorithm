package DSA.Array;

public class _12_Leetcode {

    public static int missing(int[] array) {
        int n = array.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : array) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] a = {0, 1};

        System.out.println("The missing number is : " + missing(a));
    }
}
