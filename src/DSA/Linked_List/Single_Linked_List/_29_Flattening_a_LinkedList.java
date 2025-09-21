package DSA.Linked_List.Single_Linked_List;

public class _29_Flattening_a_LinkedList {
    public Node flatten(Node root) {
        if (root == null || root.next == null) {
            return root;
        }

        // Recursively flatten the list on right
        root.next = flatten(root.next);

        // Merge current list (root) with next list
        root = merge(root, root.next);

        return root;
    }

    public static Node merge(Node list1, Node list2) {
        Node dummy = new Node(-1);
        Node t = dummy;

        Node t1 = list1;
        Node t2 = list2;

        while (t1 != null && t2 != null) {
            if (t1.data < t2.data) {
                t.bottom = new Node(t1.data);
                t = t.bottom;
                t1 = t1.bottom;
            } else {
                t.bottom = new Node(t2.data);
                t = t.bottom;
                t2 = t2.bottom;
            }
        }

        // Add remaining nodes
        while (t1 != null) {
            t.bottom = new Node(t1.data);
            t = t.bottom;
            t1 = t1.bottom;
        }

        while (t2 != null) {
            t.bottom = new Node(t2.data);
            t = t.bottom;
            t2 = t2.bottom;
        }

        return dummy.bottom;
    }

}
