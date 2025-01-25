package DSA.LeetCode.LinkedList;

import java.util.HashSet;

public class Delete_Nodes_From_Linked_List_Present_in_Array {

    public ListNode modifiedList1(int[] nums, ListNode head) {
        boolean set[] = new boolean[(int)1e5+1];
        for(int num : nums){
            set[num] = true;
        }
        ListNode prev = null;
        ListNode cur = head;
        while(cur!=null){
            if(set[cur.val]==true){
                if(prev == null){ //del at head
                    head = head.next;
                    cur.next = null;
                    cur = head;
                }else{
                    prev.next = cur.next;
                    cur.next = null;
                    cur = prev.next;
                }
            }else{
                prev = cur;
                cur = cur.next;
            }
        }
        return head;
    }

    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> hashSet = new HashSet<>();

        // Add all nums to the HashSet for quick lookup
        for (int num : nums) {
            hashSet.add(num);
        }

        // Create a dummy node to handle edge cases like deleting the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        // Traverse through the list
        while (current.next != null) {
            if (hashSet.contains(current.next.val)) {
                // Skip the node with the value in nums
                current.next = current.next.next;
            } else {
                // Move to the next node
                current = current.next;
            }
        }

        // Return the modified list, starting from the real head
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
