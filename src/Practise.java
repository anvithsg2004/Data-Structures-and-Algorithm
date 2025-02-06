public class Practise {

    public int fun(int[][] matrix) {

        int n = matrix.length;

        int maxi = 0;

        for (int[] ints : matrix) {
            maxi = Math.max(maxi, searchFor1(0, n - 1, ints));
        }

        return maxi;

    }

    public int searchFor1(int low, int high, int[] arr) {

        int index = 0;

        while (low <= high) {

            int mid = (high - low) / 2;

            if (arr[mid] == 1) {
                high = mid - 1;
                index = mid;
            } else if (arr[mid] == 0) {
                low = mid + 1;
            } else {
                high = mid + 1;
            }

        }

        return arr.length - index + 1;

    }
}
