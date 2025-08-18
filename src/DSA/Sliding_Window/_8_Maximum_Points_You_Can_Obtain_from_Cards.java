package DSA.Sliding_Window;

public class _8_Maximum_Points_You_Can_Obtain_from_Cards {
    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;

        // Step 1: take first k cards
        int frontSum = 0;
        for (int i = 0; i < k; i++) {
            frontSum += cardPoints[i];
        }

        int maxScore = frontSum;

        // Step 2: try taking some cards from the back instead
        int backSum = 0;
        for (int i = 0; i < k; i++) {
            // remove from front
            frontSum = frontSum - cardPoints[k - 1 - i];
            // add from back
            backSum = backSum + cardPoints[n - 1 - i];

            maxScore = Math.max(maxScore, frontSum + backSum);
        }

        return maxScore;

    }
}
