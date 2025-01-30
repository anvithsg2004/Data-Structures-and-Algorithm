import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class index {
    int i;
    int j;

    public index(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class Practise {

    public static int fun3(int[] arr1, int[] arr2) {

        Map<Integer, index> commonElements = new HashMap<>();

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    int element = arr1[i];
                    commonElements.put(element, new index(i, j));
                }
            }
        }

        int sum1 = 0;
        int sum2 = 0;

        //For sum1, starting from arr1.
        for (int i = 0; i < arr1.length; i++) {
            if (commonElements.containsKey(arr1[i])) {
                index curr = commonElements.get(arr1[i]);
                sum1 = sum1 + forRestOfTheSum(arr2, curr.j);
                break;
            }
            sum1 = sum1 + arr1[i];
        }

        //For sum2, starting from arr2
        for (int i = 0; i < arr2.length; i++) {
            if (commonElements.containsKey(arr1[i])) {
                index curr = commonElements.get(arr1[i]);
                sum2 = sum2 + forRestOfTheSum(arr1, curr.i);
                break;
            }
            sum2 = sum2 + arr2[i];
        }

        return Math.max(sum1, sum2);

    }

    public static int forRestOfTheSum(int[] arr, int j) {
        int sum = 0;

        for (int i = j; i < arr.length; i++) {
            sum = sum + arr[i];
        }

        return sum;
    }

    public static String fun2(String string) {

        int n = string.length();

        StringBuilder stringBuilder = new StringBuilder();

        int i = 0;

        for (int j = 0; j < n; j++) {
            if (string.charAt(i) != string.charAt(j)) {
                char ch = string.charAt(i);
                int num = j - i;
                stringBuilder.append(ch);
                stringBuilder.append(num);
                i = j;
            }
        }

        stringBuilder.append(string.charAt(i));
        stringBuilder.append(n - i);

        return stringBuilder.toString();

    }

    public static int fun1(int[] arr) {
        HashSet<Integer> nums = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                nums.add(arr[i]);
            }
        }

        ArrayList<Integer> num = new ArrayList<>(nums);

        int missing = -1;

        for (int i = 0; i < nums.size(); i++) {
            if (num.get(i) == 1) {
                continue;
            }

            if (!nums.contains(num.get(i) - 1)) {
                missing = num.get(i) - 1;
                break;
            }
        }

        return missing;
    }

    public static void main(String[] args) {
        int[] arr = {2, -3, 4, 1, 7};
        System.out.println(fun1(arr)); // Expected: 3

        String s = "aabcccccaaa";
        System.out.println(fun2(s)); // Expected: "a2b1c5a3"

        int[] arr1 = {1, 2, 3};
        int[] arr2 = {3, 4, 5};
        System.out.println(fun3(arr1, arr2)); // Expected: 9
    }

}
