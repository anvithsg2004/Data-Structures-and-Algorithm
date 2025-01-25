package DSA.Practice.Linked_List.Easy;

public class _2_Design_HashSet {

    ListNode head = new ListNode();

    class MyHashSet {

        public MyHashSet() {

        }

        public void add(int key) {

            ListNode current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = new ListNode(key);

        }

        public void remove(int key) {

            ListNode dummy = new ListNode(-1);
            ListNode tail = dummy;

            ListNode current = head;

            while (current != null) {

                if (current.val != key) {
                    tail.next = new ListNode(current.val);
                    tail = tail.next;
                }

                current = current.next;

            }

        }

        public boolean contains(int key) {

            ListNode current = head;

            while (current != null) {

                if (current.val == key) {
                    return true;
                }

                current = current.next;
            }

            return false;

        }
    }

    public static void main(String[] args) {

    }
}
