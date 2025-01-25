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

    public static void main(String[] args) {
        int[] array = {1, 1, 0, 1, 1, 1};

        System.out.println("The maximum Consecutive Ones : " + ones(array));
    }
}
