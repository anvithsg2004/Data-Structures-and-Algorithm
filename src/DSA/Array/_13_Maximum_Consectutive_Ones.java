package DSA.Array;

public class _13_Maximum_Consectutive_Ones {

    public static int ones(int[] array) {
        int maxi = 0;
        int cnt = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                cnt++;
                maxi = Math.max(maxi, cnt);
            } else {
                cnt = 0;
            }
        }

        return maxi;
    }
}
