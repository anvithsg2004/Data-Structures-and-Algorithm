package DSA.Strings;

public class _6_Sort_a_String {
    public String sort(String s) {
        if (s == null) {
            return null;
        }

        int[] alpha = new int[26];

        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'a']++;
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < alpha.length; i++) {
            for (int j = 0; j < alpha[i]; j++) {
                ans.append((char) (i + 'a'));
            }
        }

        return ans.toString();
    }
}
