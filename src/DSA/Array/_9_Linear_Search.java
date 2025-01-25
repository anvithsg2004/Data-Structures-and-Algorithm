package DSA.Array;

public class _9_Linear_Search {

    public static void linear(int[] array, int search) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == search) {
                System.out.println("The Value is in " + i + "th Index.");
                return;
            }
        }
        System.out.println("Value not found");
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int search = 5;
        linear(array, search);
    }
}
