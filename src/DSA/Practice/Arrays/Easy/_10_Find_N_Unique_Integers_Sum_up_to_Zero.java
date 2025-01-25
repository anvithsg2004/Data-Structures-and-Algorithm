package DSA.Practice.Arrays.Easy;

public class _10_Find_N_Unique_Integers_Sum_up_to_Zero {

    public int[] sumZero(int n) {

        int[] result = new int[n];

        int lowVal = -1;

        int highVal = 1;

        if (n % 2 != 0) {

            int mid = n / 2;

            result[mid] = 0;

            int low = mid - 1;
            int high = mid + 1;

            while (low >= 0 && high < n) {

                result[low] = lowVal;
                result[high] = highVal;

                low--;
                high++;

                lowVal = lowVal - 1;
                highVal = highVal + 1;

            }
        } else {

            int mid = (n - 1) / 2;

            int low = mid;
            int high = mid + 1;

            while (low >= 0 && high < n) {

                result[low] = lowVal;
                result[high] = highVal;

                low--;
                high++;

                lowVal = lowVal - 1;
                highVal = highVal + 1;

            }

        }

        return result;

    }

    public static void main(String[] args) {

    }
}
