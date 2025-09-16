package DSA.Array;

public class _33_Find_the_Missing_and_Repeating_Number {

    //Hashing
    public int[] findTwoElement(int[] arr) {

        int n = arr.length;

        int[] hash = new int[n];

        for (int i = 0; i < n; i++) {

            hash[arr[i]]++;

        }

        //Find the repeating and missing number:
        int repeating = -1;
        int missing = -1;

        for (int i = 1; i <= n; i++) {

            if (hash[i] == 2) {
                repeating = i;
            } else if (hash[i] == 0) {
                missing = i;
            }

            //If we got the Value then stop "ans" return the value.
            if (repeating != -1 && missing != -1)
                break;

        }

        return new int[]{repeating, missing};

    }

    public int[] findTwoMissing(int[] arr, int n) {
        int[] hash = new int[n + 1];
        int[] missing = new int[2];
        int idx = 0;

        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]] = 1;
        }

        for (int i = 1; i <= n; i++) {
            if (hash[i] == 0) {
                missing[idx++] = i;
                if (idx == 2) break;
            }
        }

        return missing;
    }

    public int[] findTwoRepeating(int[] arr) {
        int n = arr.length;
        int[] hash = new int[n + 1];
        int[] repeating = new int[2];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (hash[i] > 1) {
                repeating[idx++] = i;
                if (idx == 2) break;
            }
        }

        return repeating;
    }
}
