package DSA.Recursion.Kunal_Kushwaha.Permutations;

import java.util.ArrayList;

public class _2_ArrayList {

    public static ArrayList<String> permutation(String p, String up) {

        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);

        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i <= p.length(); i++) {

            String f = up.substring(0, i);
            String s = up.substring(i, p.length());
            ans.addAll(permutation(f + ch + s, up.substring(1)));

        }

        return ans;

    }
}
