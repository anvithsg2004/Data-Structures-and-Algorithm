package DSA.LeetCode.Trees;

public class Number_of_Good_Leaf_Nodes_Pairs {

    int res = 0;

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return res;
    }

    public int[] dfs(TreeNode root, int distnce) {
        int[] leafDist = new int[11];
        if (root == null) {
            return leafDist;
        }
        else if (root.left == null && root.right == null) {
            leafDist[1] = 1;
            return leafDist;
        }

        int leftDist[] = dfs(root.left, distnce);
        int rightDist[] = dfs(root.right, distnce);

        for (int d1 = 1; d1 < 11; d1++) {
            for (int d2 = 1; d2 < 11; d2++) {
                if (d1 + d2 <= distnce) {
                    res = res + (leftDist[d1] * rightDist[d2]);
                }
            }
        }

        for (int d = 1; d < 11; d++) {
            leafDist[d] = leftDist[d - 1] + rightDist[d - 1];
        }

        return leafDist;
    }

    public static void main(String[] args) {

    }
}
