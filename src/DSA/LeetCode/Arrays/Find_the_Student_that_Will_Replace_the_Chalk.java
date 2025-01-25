package DSA.LeetCode.Arrays;

public class Find_the_Student_that_Will_Replace_the_Chalk {

    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum = sum + chalk[i];
        }

        long remainingChalk = k % sum;

        for (int i = 0; i < n; i++) {
            remainingChalk -= chalk[i];
            if (remainingChalk < 0) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
