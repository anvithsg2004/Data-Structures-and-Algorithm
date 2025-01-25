package DSA.LeetCode.Greedy;

public class Count_Number_of_Teams {

    public int numTeams(int[] rating) {
        int n = rating.length;
        int count = 0;
        for (int mid = 1; mid < n - 1; mid++) {
            int leftSmallerCount = 0;
            for (int i = 0; i < mid; i++) {
                if (rating[i] < rating[mid]) {
                    leftSmallerCount++;
                }
            }

            int rightGreaterCount = 0;
            for (int i = mid + 1; i < n; i++) {
                if (rating[i] > rating[mid]) {
                    rightGreaterCount++;
                }
            }

            //Inc
            count += leftSmallerCount * rightGreaterCount;
            int leftGreaterCount = mid - leftSmallerCount;
            int rightSmallerCount = n - mid - 1 - rightGreaterCount;
            //Dec
            count += leftGreaterCount * rightSmallerCount;
        }

        return count;
    }

    public static void main(String[] args) {

    }
}
