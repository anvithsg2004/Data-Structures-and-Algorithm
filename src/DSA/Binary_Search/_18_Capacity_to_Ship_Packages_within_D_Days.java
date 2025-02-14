package DSA.Binary_Search;

//Example = Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
//Output: 15
//Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
//1st day: 1, 2, 3, 4, 5
//2nd day: 6, 7
//3rd day: 8
//4th day: 9
//5th day: 10
//
//Note that the cargo must be shipped in the order given, so using a ship of capacity 14
//and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.

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
}
