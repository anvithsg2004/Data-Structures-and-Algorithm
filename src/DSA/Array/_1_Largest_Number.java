package DSA.Array;

public class _1_Largest_Number {

    public static int largest(int[] array) {
        int largest = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > largest) {
                largest = array[i];
            }
        }

        return largest;
    }

    public static void main(String[] args) {
     int[] array = {3, 2, 1, 5, 2, 69, 100, 0, 32};
        System.out.println("The largest element is : " + largest(array));
    }
}
