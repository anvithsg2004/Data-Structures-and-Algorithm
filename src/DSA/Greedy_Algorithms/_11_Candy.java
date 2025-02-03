package DSA.Greedy_Algorithms;

public class _11_Candy {

    //Brute Force
    public int candy(int[] ratings) {

        int n = ratings.length;

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        right[n - 1] = 1;

        //Coming from the front.
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        //Coming from the back.
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            answer = answer + Math.max(left[i], right[i]);
        }

        return answer;

    }
}
