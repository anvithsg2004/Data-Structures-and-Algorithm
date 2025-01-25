package DSA.Practice.Binary_Search.Medium;

public class _7_Minimized_Maximum_of_Products_Distributed_to_Any_Store {

    public boolean isPossible(int[] quantities, int maxProducts, int stores) {

        int storeCount = 0;

        for (int i = 0; i < quantities.length; i++) {

            storeCount = storeCount + (quantities[i] / maxProducts);

            if (quantities[i] % maxProducts != 0) {
                storeCount = storeCount + 1;
            }

            if (storeCount > stores) {
                return false;
            }

        }

        return true;

    }

    public int minimizedMaximum(int n, int[] quantities) {

        int low = 1;
        int high = Integer.MIN_VALUE;

        for (int i = 0; i < quantities.length; i++) {
            high = Math.max(high, quantities[i]);
        }

        int result = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (isPossible(quantities, mid, n)) {

                result = mid;
                high = mid - 1;

            } else {

                low = mid + 1;

            }

        }

        return result;

    }

    public static void main(String[] args) {

    }
}
