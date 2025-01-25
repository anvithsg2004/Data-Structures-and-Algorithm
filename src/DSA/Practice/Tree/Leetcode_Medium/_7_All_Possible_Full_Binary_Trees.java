package DSA.Practice.Tree.Leetcode_Medium;

import java.util.ArrayList;
import java.util.List;

public class _7_All_Possible_Full_Binary_Trees {

    //See Video

    public List<TreeNode> allPossibleFBT(int n) {
        return helper(n);
    }

    public List<TreeNode> helper(int n) {
        if (n == 1) {
            ArrayList<TreeNode> base = new ArrayList<>();
            base.add(new TreeNode(0));
            return base;
        }

        //Always choose odd numbers to choose.
        ArrayList<TreeNode> ans = new ArrayList<>();
        for (int i = 1; i < n; i = i + 2) {
            List<TreeNode> left = helper(i);
            List<TreeNode> right = helper(n - i - 1);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
