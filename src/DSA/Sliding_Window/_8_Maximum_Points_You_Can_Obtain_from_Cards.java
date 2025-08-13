package DSA.Sliding_Window;

public class _8_Maximum_Points_You_Can_Obtain_from_Cards {
    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;

        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum = totalSum + cardPoints[i];
        }

        int windowSize = n - k;

        int windowSum = 0;

        int miniWindow = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            windowSum = windowSum + cardPoints[i];

            if (i >= windowSize) {
                windowSum = windowSum - cardPoints[i - windowSize];
            }

            if (i >= windowSize - 1) {
                miniWindow = Math.min(miniWindow, windowSum);
            }

        }

        return totalSum - miniWindow;

    }
}
