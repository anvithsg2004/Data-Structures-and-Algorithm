package DSA.Array;

public class _13_Maximum_Consecutive_Ones {

    public static int ones(int[] array) {
        int maxi = 0;
        int cnt = 0;

        //Here, we apply simple logic.
        //Traverse through the elements.
        for (int i = 0; i < array.length; i++) {
            //If we get the '1' then increase the count.
            //Update the maxLength.
            if (array[i] == 1) {
                cnt++;
                maxi = Math.max(maxi, cnt);
            } else {
                //If you get any other than assign the count to 0.
                //Start freshly from there.
                cnt = 0;
            }
        }

        return maxi;
    }
}
