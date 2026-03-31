//import java.util.*;
//
//class Solution {
//    public List<List<String>> accountsMerge(List<List<String>> accounts) {
//
//        int n = accounts.size();
//
//        DisjointSet ds = new DisjointSet(n);
//
//        HashMap<String, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 1; j < accounts.get(i).size(); j++) {
//
//
//                String email = accounts.get(i).get(j);
//
//                if (map.containsKey(email) == false) {
//                    map.put(email, i);
//                } else {
//                    ds.union(i, map.get(email));
//                }
//
//            }
//        }
//
//        HashMap<Integer, List<Integer>> merged = new HashMap<>();
//
//        for (String email : map.keySet()) {
//
//            int parent = ds.find(merged.get(email));
//
//            merged.putIfAbsent(parent, new ArrayList<>());
//            merged.get(parent).add(email);
//
//        }
//
//
//
//    }
//
//    class DisjointSet {
//
//        int[] parent;
//        int[] rank;
//
//        public DisjointSet(int n) {
//
//            parent = new int[n];
//            rank = new int[n];
//
//            for (int i = 0; i < n; i++) {
//                parent[i] = i;
//                rank[i] = 0;
//            }
//
//        }
//
//        public int find(int node) {
//
//            if (node == parent[node]) {
//                return node;
//            }
//
//            return parent[node] = find(parent[node]);
//
//        }
//
//        public void union(int u, int v) {
//
//            int pu = find(u);
//            int pv = find(v);
//
//            if (pu == pv) {
//                return;
//            }
//
//            if (rank[pv] < rank[pu]) {
//                parent[pv] = pu;
//            } else if (rank[pu] < rank[pv]) {
//                parent[pu] = pv;
//            } else {
//                parent[pv] = pu;
//                rank[pu]++;
//            }
//
//        }
//
//    }
//
//}
