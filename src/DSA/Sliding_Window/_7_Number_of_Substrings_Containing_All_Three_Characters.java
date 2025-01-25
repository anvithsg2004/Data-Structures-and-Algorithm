package DSA.Sliding_Window;

public class _7_Number_of_Substrings_Containing_All_Three_Characters {

    //Brute Force Solution
    public int numberOfSubstrings2(String s) {

        int n = s.length();

        int count = 0;

        for (int i = 0; i < n; i++) {
            int[] hash = new int[3];

            for (int j = i; j < n; j++) {
                hash[s.charAt(i) - 'a'] = 1;
                if (hash[0] + hash[1] + hash[2] == 3) {
                    count = count + 1;
                }
            }
        }

        return count;

    }

    //Optimal Solution
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] lastSeen = new int[]{-1, -1, -1};
        int count = 0;

        for (int i = 0; i <= n; i++) {
            lastSeen[s.charAt(i) - 'a'] = i;
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                count = count + (1 + Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2])));
            }
        }

        return count;
    }
}
