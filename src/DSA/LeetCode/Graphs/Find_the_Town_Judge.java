package DSA.LeetCode.Graphs;

public class Find_the_Town_Judge {

    public int findJudge(int n, int[][] trust) {

        if (n == 1 && trust.length == 0) return 1;

        int[] indegree = new int[n + 1];
        int[] outdegree = new int[n + 1];

        for (int[] go : trust) {
            int a = go[0];
            int b = go[1];

            outdegree[a]++;
            indegree[b]++;
        }

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == n - 1 && outdegree[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
