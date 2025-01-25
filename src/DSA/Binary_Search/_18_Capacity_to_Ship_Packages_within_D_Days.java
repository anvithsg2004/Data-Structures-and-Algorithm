package DSA.Binary_Search;

public class _18_Capacity_to_Ship_Packages_within_D_Days {

    public int findDays(int[] arr, int cap) {
        int day = 1;
        int load = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            //If the capacity exceeds than load it to the next day.
            if (load + arr[i] > cap) {
                day = day + 1;
                load = arr[i];
            } else {
                //If the capacity do not exceed then just add the loads.
                load = load + arr[i];
            }
        }

        return day;
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        int high = 0;

        //The answer will be between the max element and the summation of all the elements.
        for (int i = 0; i < weights.length; i++) {
            high += weights[i];
            low = Math.max(low, weights[i]);
        }

        //Set the low as the max element.
        //High as the summation of all the elements.

        while (low <= high) {
            int mid = (low + high) / 2;
            int numbOfD = findDays(weights, mid);

            if (numbOfD <= days) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {

    }
}
