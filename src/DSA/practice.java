package DSA;

//Given an array 'n' integers and target value, find the pair of elements whose sum is target.

import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

public class practice {

    public static boolean helper(int[] arr, int target) {

        if (arr == null || arr.length < 2) {
            return false;
        }

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int diff = arr[left] + arr[right];

            if (diff > target) {
                right--;
            } else if (diff < target) {
                left++;
            } else {
                return true;
            }

        }

        return false;

    }

    // Function to perform post-order traversal and calculate subtree sums
    public int postOrderSum(TreeNode node, List<Integer> subtreeSums) {
        if (node == null) {
            return 0;
        }

        // Calculate the sum of the left subtree
        int leftSum = postOrderSum(node.left, subtreeSums);

        // Calculate the sum of the right subtree
        int rightSum = postOrderSum(node.right, subtreeSums);

        // Calculate the total sum of the current subtree (node + leftSum + rightSum)
        int currentSum = node.val + leftSum + rightSum;

        // Add the current subtree sum to the list
        subtreeSums.add(currentSum);

        // Return the current subtree sum to the parent node
        return currentSum;
    }

    // Helper method to initialize the List and start post-order traversal
    public List<Integer> getSubtreeSums(TreeNode root) {
        List<Integer> subtreeSums = new ArrayList<>();
        postOrderSum(root, subtreeSums);
        return subtreeSums;
    }

    public static void main(String[] args) {

        int[] arr = {0, -1, 2, 3, 1};
        int target = -2;

        System.out.println(helper(arr, target));

//        practice tree = new practice();
//
//        // Creating a sample tree:
//        //      1
//        //     / \
//        //    2   3
//        //   / \
//        //  4   5
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//
//        // Get the subtree sums
//        List<Integer> subtreeSums = tree.getSubtreeSums(root);
//
//        // Print the sums of each subtree
//        System.out.println("Subtree sums: " + subtreeSums);

        String s = "egg";

        System.out.println(s + s);
    }
}


//public class practice {
//    public static void main(String[] args) {
////        char c = '1';
////        String s = "Hello how are you Contestant";
////        String[] words = s.split(" ");
////        System.out.println(Arrays.toString(Arrays.stream(words).toArray()));
////        System.out.println(Character.getNumericValue(c));
////        System.out.println(s.charAt(0));
//    }
//}
