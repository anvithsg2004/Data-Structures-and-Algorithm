package DSA.Linked_List.Double_Linked_List;

import java.util.ArrayList;
import java.util.List;

public class _5_Find_all_Pairs_with_given_Sum {
    public List<int[]> pairs(Node head, int sum) {

        List<int[]> result = new ArrayList<>();

        Node temp1 = head;
        while (temp1 != null) {
            Node temp2 = temp1.next;

            while (temp2 != null) {
                if (temp1.data + temp2.data == sum) {
                    result.add(new int[]{temp1.data, temp2.data});
                }
                temp2 = temp2.next;
            }

            temp1 = temp1.next;
        }

        return result;

    }
}
