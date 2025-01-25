import java.util.Arrays;

public class Practise {

    public static int help(String str) {

        int[] hash = new int[26];

        int n = str.length();

        for (int i = 0; i < n; i++) {

            hash[str.charAt(i) - 'a']++;

        }

        for (int i = 0; i < n; i++) {
            if (hash[str.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;

    }

    public static int[] helper(int[] arr, int k) {

        int n = arr.length;

        int[] temp = new int[k];

        for (int i = 0; i < k; i++) {
            temp[i] = arr[n + i - k];
        }

        for (int i = n - 1; i >= k; i--) {
            arr[i] = arr[i - k];
        }

        for (int i = 0; i < k; i++) {
            arr[i] = temp[i];
        }

        return arr;

    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 3;
        System.out.println(Arrays.toString(helper(arr, k)));

    }
}
