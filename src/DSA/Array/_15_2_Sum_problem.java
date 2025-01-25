package DSA.Array;

import java.util.HashSet;

public class _15_2_Sum_problem {

    //Use Hashing
    public static boolean _2_sum(int[] array, int target) {
        HashSet<Integer> mpp = new HashSet<>();
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int num = array[i];
            //Check this If it has more in the map.
            int moreNeeded = target - num;

            //If yes, then return true.
            if (mpp.contains(moreNeeded)) {
                return true;
            }

            mpp.add(array[i]);
        }

        //Else False.
        return false;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 1, 1, 1, 1, 4, 2, 3};

        int target = 10;

        System.out.println("The Target is : " + _2_sum(array, target));
    }
}
