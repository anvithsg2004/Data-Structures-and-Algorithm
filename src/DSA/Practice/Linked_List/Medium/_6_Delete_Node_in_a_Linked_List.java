package DSA.Practice.Linked_List.Medium;

public class _6_Delete_Node_in_a_Linked_List {

    public void deleteNode(ListNode node) {

        //In this problem we won't get the linked list.
        //Just the removable node.
        //Use this technique for this.
        node.val = node.next.val;
        node.next = node.next.next;

    }

    public static void main(String[] args) {

    }
}
