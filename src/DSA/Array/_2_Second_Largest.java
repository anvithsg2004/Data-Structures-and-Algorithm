package DSA.Array;

public class _2_Second_Largest {

    public static int slargest(int[] array) {
        int largest = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > largest) {
                largest = array[i];
            }
        }

        int slargest = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != largest && array[i] > slargest) {
                slargest = array[i];
            }
        }

        return slargest;
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 1, 5, 2, 7};
        System.out.println("The Second Largest is : " + slargest(array));
    }
}
