package DSA.Array;

public class _12_Leetcode {

    public static int missing(int[] array) {
        int n = array.length;
        //Simple formula to get the sum of all elements.
        int expectedSum = n * (n + 1) / 2;
        //Subtract with the actual sum of the elements.
        int actualSum = 0;
        for (int num : array) {
            actualSum += num;
        }

        //Finally, we get the missing number.
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] a = {0, 1};

        System.out.println("The missing number is : " + missing(a));
    }
}
