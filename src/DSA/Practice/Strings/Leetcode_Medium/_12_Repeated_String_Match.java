package DSA.Practice.Strings.Leetcode_Medium;

public class _12_Repeated_String_Match {

    public int repeatedStringMatch(String a, String b) {

        StringBuilder repeatedA = new StringBuilder(a);
        int count = 1;  // Initially, we have one instance of `a`

        // Keep appending `a` until `repeatedA`'s length is greater than or equal to `b`
        while (repeatedA.length() < b.length()) {
            repeatedA.append(a);
            count++;
        }

        // Check if the current repeated version of `a` contains `b`
        if (repeatedA.toString().contains(b)) {
            return count;
        }

        // Append one more time to check for cases where `b` might straddle two `a`s
        repeatedA.append(a);
        count++;

        // Check again after the additional repeat
        if (repeatedA.toString().contains(b)) {
            return count;
        }

        // If `b` is still not found, return -1
        return -1;

    }

    public static void main(String[] args) {

    }
}
