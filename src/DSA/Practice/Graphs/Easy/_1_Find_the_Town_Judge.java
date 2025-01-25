package DSA.Practice.Graphs.Easy;

public class _1_Find_the_Town_Judge {

    public int findJudge(int n, int[][] trust) {
        if (n == 1 && trust.length == 0) {
            return 1;
        }

        // Arrays to track in-degrees and out-degrees
        int[] inDegree = new int[n + 1];
        int[] outDegree = new int[n + 1];

        // Populate in-degree and out-degree counts
        for (int[] t : trust) {
            int u = t[0];
            int v = t[1];
            outDegree[u]++;
            inDegree[v]++;
        }

        // Check for the town judge
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == n - 1 && outDegree[i] == 0) {
                return i;
            }
        }

        return -1; // No judge found
    }

    public static void main(String[] args) {

    }
}
