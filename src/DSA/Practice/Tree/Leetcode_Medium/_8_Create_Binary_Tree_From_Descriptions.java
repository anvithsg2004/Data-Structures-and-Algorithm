package DSA.Practice.Tree.Leetcode_Medium;

import java.util.HashMap;
import java.util.Map;

public class _8_Create_Binary_Tree_From_Descriptions {
    public TreeNode createBinaryTree(int[][] descriptions) {

        //This is to get the parent node
        //  Parent/Child Value    Parent/Child TreeNode
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        //This is to check whether it has a parent or not
        Map<Integer, Boolean> hasParent = new HashMap<>();

        //Iterate through the descriptions
        for (int[] description : descriptions) {
            //Parent
            int parentVal = description[0];
            //Child
            int childVal = description[1];
            //Left or right
            boolean isLeft = description[2] == 1;

            //To make or get the parent
            TreeNode parent;
            if (nodeMap.containsKey(parentVal)) {
                //If the parent is already present
                parent = nodeMap.get(parentVal);
            } else {
                //Then create the parent
                parent = new TreeNode(parentVal);
                nodeMap.put(parentVal, parent);
            }

            //To make or get the child
            TreeNode child;
            if (nodeMap.containsKey(childVal)) {
                //If the child is already present
                child = nodeMap.get(childVal);
            } else {
                //If the is not present
                child = new TreeNode(childVal);
                nodeMap.put(childVal, child);
            }

            //Put it for left or right
            if (isLeft) {
                parent.left = child;
            } else {
                parent.right = child;
            }

            //Put that to check for further operations.
            hasParent.put(childVal, true);
            hasParent.putIfAbsent(parentVal, false);
        }

        // Step 2: Find the root (the node that has no parent)
        for (int key : nodeMap.keySet()) {
            if (!hasParent.get(key)) {
                return nodeMap.get(key);  // Return the root node
            }
        }

        return null;
    }
}
