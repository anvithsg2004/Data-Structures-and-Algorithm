package DSA.Practice.Tree.GFG_Medium;

import java.util.ArrayList;

public class _3_Fixing_Two_nodes_of_a_BST {
    public void correctBST(Node root) {

        ArrayList<Node> nodes = new ArrayList<>();
        inorder(root, nodes);

        int n = nodes.size();

        int firstNumber = 0;
        int secondNumber = 0;

        Node firstToSecond = null;
        Node secondToFirst = null;

        for (int i = 0; i < n - 1; i++) {
            Node current = nodes.get(i);
            Node next = nodes.get(i + 1);

            if (current.data > next.data) {
                firstNumber = next.data;
                firstToSecond = next;
                break;
            }
        }

        for (int i = 0; i < n - 1; i++) {
            Node current = nodes.get(i);
            Node next = nodes.get(i + 1);
            if (current.data > next.data && firstNumber != next.data) {
                secondNumber = next.data;
                secondToFirst = next;
                break;
            }
        }

        System.out.println(firstNumber);
        System.out.println(secondNumber);

        firstToSecond.data = secondNumber;

        secondToFirst.data = firstNumber;


    }

    public void inorder(Node root, ArrayList<Node> nodes) {

        if (root == null) {
            return;
        }

        inorder(root.left, nodes);
        nodes.add(root);
        inorder(root.right, nodes);

    }
}
