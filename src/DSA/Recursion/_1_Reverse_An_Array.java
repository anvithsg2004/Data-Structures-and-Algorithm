package DSA.Recursion;

public class _1_Reverse_An_Array {

    public void reverse_Array(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }

        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        reverse_Array(arr, start + 1, end - 1);

    }

    public static void main(String[] args) {

    }
}
