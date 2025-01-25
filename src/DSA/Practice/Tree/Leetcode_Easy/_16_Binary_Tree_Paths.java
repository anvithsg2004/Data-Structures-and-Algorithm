package DSA.Practice.Tree.Leetcode_Easy;

import java.util.ArrayList;
import java.util.List;

public class _16_Binary_Tree_Paths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) {
            allPath(root, "", result);
        }
        return result;
    }

    public void allPath(TreeNode root, String path, List<String> strings) {
        if (root == null) {
            return;
        }

        path = path + root.val;

        if (root.left == null && root.right == null) {
            strings.add(path);
        } else {
            path = path + "→";
            allPath(root.left, path, strings);
            allPath(root.right, path, strings);
        }
    }

    public static void main(String[] args) {

    }
}

//Example :=

//Start at the root (1):
//
//path = "1"
//Call allPath(root.left, "1→", strings) for the left child.
//At node 2:
//
//path = "1→2"
//Since node 2 is a leaf, add "1→2" to strings.
//Return from the recursive call, and path for node 1 still remains as "1→".
//Now, traverse the right child (3):
//
//path = "1→"
//Call allPath(root.right, "1→", strings).
//At node 3:
//
//path = "1→3"
//Since node 3 is a leaf, add "1→3" to strings.
