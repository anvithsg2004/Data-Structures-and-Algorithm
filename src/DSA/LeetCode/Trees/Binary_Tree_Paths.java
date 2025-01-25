package DSA.LeetCode.Trees;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Paths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        dfs(root, "", ans);
        return ans;
    }

    public void dfs(TreeNode root, String path, List<String> ans) {
        if (root == null) {
            return;
        }

        path = path + root.val;

        if (root.left == null && root.right == null) {
            ans.add(path);
        }
        else {
            path = path + "->";
            dfs(root.left, path, ans);
            dfs(root.right, path, ans);
        }
    }

    public static void main(String[] args) {

    }
}
