package DSA.Stack_and_Queue;

import java.util.ArrayList;
import java.util.List;

public class _14_Stock_Span_Problem {

    List<Integer> list;

    public _14_Stock_Span_Problem() {
        list = new ArrayList<>();
    }

    public int next(int price) {

        list.add(price);
        int count = 1;

        for (int i = list.size() - 2; i >= 0; i--) {
            if (list.get(i) <= price) {
                count++;
            } else {
                break;
            }
        }

        return count;

    }
}
