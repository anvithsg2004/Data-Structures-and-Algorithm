package DSA.Graphs._5_Minimum_Spanning_Tree;

import java.util.*;

public class _9_Accounts_Merge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        _4_Union_by_Rank ds = new _4_Union_by_Rank(n);
        HashMap<String, Integer> mapMailNode = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (mapMailNode.containsKey(mail) == false) {
                    mapMailNode.put(mail, i);
                } else {
                    ds.unionByRank(i, mapMailNode.get(mail));
                }
            }
        }

        ArrayList<String>[] mergeMail = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            mergeMail[i] = new ArrayList<>();
        }

        for (Map.Entry<String, Integer> it : mapMailNode.entrySet()) {
            String mail = it.getKey();
            int node = ds.findPar(it.getValue());
            mergeMail[node].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (mergeMail[i].size() == 0) {
                continue;
            }
            Collections.sort(mergeMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for (String it : mergeMail[i]) {
                temp.add(it);
            }
            ans.add(temp);
        }

        return ans;
    }
}
