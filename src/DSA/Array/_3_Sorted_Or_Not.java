package DSA.Array;

public class _3_Sorted_Or_Not {

    public static void check(int[] array) {
        int flag = 0;

        for (int i = 0; i < array.length-1; i++) {
            if (array[i] > array[i+1]) {
                flag = 1;
            }
        }

        if (flag == 0) {
            System.out.println("The Array is SORTED.");
        }
        else {
            System.out.println("The Array is NOT SORTED");
        }
    }

    public static void main(String[] args) {
        int[] array = {3,4,5,1,2};
        check(array);
    }
}
