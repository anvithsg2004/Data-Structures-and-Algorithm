package DSA.Practice.Binary_Search.Medium;

public class _6_Maximize_the_Confusion_of_an_Exam {

    public boolean isPossible(String answerKey, int k, int consecutive) {

        // Check maximum consecutive 'F's we can get by changing 'T's to 'F's
        int firstConsecutive = 0, firstCount = 0, left = 0;
        for (int right = 0; right < answerKey.length(); right++) {
            if (answerKey.charAt(right) == 'T') {
                firstCount++;
            }
            while (firstCount > k) {
                if (answerKey.charAt(left) == 'T') {
                    firstCount--;
                }
                left++;
            }
            firstConsecutive = Math.max(firstConsecutive, right - left + 1);
        }

        // Check maximum consecutive 'T's we can get by changing 'F's to 'T's
        int secondConsecutive = 0, secondCount = 0;
        left = 0;
        for (int right = 0; right < answerKey.length(); right++) {
            if (answerKey.charAt(right) == 'F') {
                secondCount++;
            }
            while (secondCount > k) {
                if (answerKey.charAt(left) == 'F') {
                    secondCount--;
                }
                left++;
            }
            secondConsecutive = Math.max(secondConsecutive, right - left + 1);
        }

        // Check if the maximum of either consecutive 'F's or 'T's meets the required length
        return Math.max(firstConsecutive, secondConsecutive) >= consecutive;
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {

        int n = answerKey.length();
        int low = 1;
        int high = n;
        int answer = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(answerKey, k, mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
