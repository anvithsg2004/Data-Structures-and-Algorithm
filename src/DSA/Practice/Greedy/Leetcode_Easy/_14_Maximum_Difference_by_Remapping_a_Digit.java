package DSA.Practice.Greedy.Leetcode_Easy;

public class _14_Maximum_Difference_by_Remapping_a_Digit {
    public int minMaxDifference(int num) {
        StringBuilder newString = new StringBuilder(String.valueOf(num));
        int n = newString.length();

        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;


        //My Mistakes
        //StringBuilder tempString1 = new StringBuilder(newString); // Create a new copy
        //StringBuilder tempString1 = newString; // Make this as the reference.


        for (int i = 0; i < n; i++) {
            // Calculate minimum
            StringBuilder tempString1 = new StringBuilder(newString); // Create a new copy
            for (int j = 0; j < n; j++) {
                if (tempString1.charAt(j) == newString.charAt(i)) {
                    tempString1.setCharAt(j, '0'); // Replace it with '0' for the minimum.
                }
            }
            int convertedBack1 = Integer.parseInt(tempString1.toString());
            mini = Math.min(convertedBack1, mini);

            // Calculate maximum
            StringBuilder tempString2 = new StringBuilder(newString); // Create another new copy
            for (int j = 0; j < n; j++) {
                if (tempString2.charAt(j) == newString.charAt(i)) {
                    tempString2.setCharAt(j, '9'); // Replace it with '9' for the maximum.
                }
            }
            int convertedBack2 = Integer.parseInt(tempString2.toString());
            maxi = Math.max(convertedBack2, maxi);
        }

        return maxi - mini;
    }
}
