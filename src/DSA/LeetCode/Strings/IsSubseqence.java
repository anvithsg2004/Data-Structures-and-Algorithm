package DSA.LeetCode.Strings;

import java.util.ArrayList;
import java.util.Arrays;

public class IsSubseqence {

    public boolean fun(String s, String t) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < t.length(); i++) {
            arrayList.add(String.valueOf(t.charAt(i)));
        }

        int sIndex = 0;

        for (int tIndex = 0; tIndex < arrayList.size(); tIndex++) {
            if (sIndex < s.length() && arrayList.get(tIndex).equals(String.valueOf(s.charAt(sIndex)))) {
                sIndex++;
            }
            if (sIndex == s.length()) {
                return true;
            }
        }

        return sIndex == s.length();
    }

    public static void main(String[] args) {

    }
}
