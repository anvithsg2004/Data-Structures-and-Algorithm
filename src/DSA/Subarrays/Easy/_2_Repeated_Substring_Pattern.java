package DSA.Subarrays.Easy;

public class _2_Repeated_Substring_Pattern {
    public boolean repeatedSubstringPattern(String s) {

        int n = s.length();

        for (int i = 1; i <= n / 2; i++) {
            String sub = s.substring(0, i);

            if (n % i == 0) {

                StringBuilder repeated = new StringBuilder();

                for (int j = 0; j < n / i; j++) {
                    repeated.append(sub);
                }

                if (repeated.toString().equals(s)) {
                    return true;
                }

            }
        }

        return false;

    }
}
