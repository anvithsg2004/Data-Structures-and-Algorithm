package DSA.Practice.Tree.GFG_Medium;

import java.util.ArrayList;
import java.util.Collections;

public class _3_Fixing_Two_nodes_of_a_BST {

    //Optimal Solution

    //Example 1: Non-Adjacent Swapped Nodes
    //Given BST (swapped nodes: 5 and 25):
    //Original inorder: [3, 5, 7, 8, 10, 15, 20, 25]
    //Swapped inorder: [3, 25, 7, 8, 10, 15, 20, 5]
    //
    //Steps:
    //
    //25 is greater than 7 → first violation (first = 25, middle = 7)
    //5 is smaller than 20 → second violation (last = 5)
    //Swap first (25) and last (5) to fix the BST.

    //Example 2: Adjacent Swapped Nodes
    //Given BST (swapped nodes: 7 and 8):
    //Original inorder: [3, 5, 7, 8, 10, 15, 20, 25]
    //Swapped inorder: [3, 5, 8, 7, 10, 15, 20, 25]
    //
    //Steps:
    //
    //7 is smaller than 8 → only one violation (first = 8, middle = 7)
    //Since no second violation, swap first (8) and middle (7).

    Node first = null, middle = null, last = null, prev = null;

    public void recoverTree(Node root) {

        //When the nodes are not adjacent.
        if (last != null) {
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        }
        //When Nodes are adjacent
        else {
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }

    }

    public void inorder(Node root) {

        if (root == null) {
            return;
        }

        inorder(root.left);

        if (prev != null && root.data < prev.data) {
            if (first == null) {//This is the First violation
                first = prev;
                middle = root;
            } else {//This is the second violation
                last = root;
            }
        }

        //This is to keep the previous node data which will be used to exchange.
        prev = root;

        inorder(root.right);

    }

    //Brute Force Solution
    public void correctBST(Node root) {

        ArrayList<Integer> nodes = new ArrayList<>();
        findInorder(root, nodes);

        Collections.sort(nodes);

        int[] index = new int[1];
        index[0] = 0;

        constructTree(root, nodes, index);

    }

    public void constructTree(Node root, ArrayList<Integer> nodes, int[] index) {

        if (root == null) {
            return;
        }

        constructTree(root.left, nodes, index);

        root.data = nodes.get(index[0]);
        index[0]++;

        constructTree(root.right, nodes, index);

    }

    public void findInorder(Node root, ArrayList<Integer> nodes) {

        if (root == null) {
            return;
        }

        findInorder(root.left, nodes);
        nodes.add(root.data);
        findInorder(root.right, nodes);

    }
}
