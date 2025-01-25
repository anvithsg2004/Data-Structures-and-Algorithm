package DSA.Stack_and_Queue;

import java.util.Stack;

class Pair1 {
    int value;
    int index;

    public Pair1(int value, int index) {
        this.value = value;
        this.index = index;
    }
}

public class _15_Stock_Span_Problem {
    Stack<Pair1> stack;

    int index = -1;

    public _15_Stock_Span_Problem() {
        stack = new Stack<>();
    }

    public int next(int price) {

        index = index + 1;

        while (!stack.isEmpty() && stack.peek().value <= price) {
            stack.pop();
        }

        int answer = index - (stack.isEmpty() ? -1 : stack.peek().index);

        stack.push(new Pair1(price, index));

        return answer;

    }
}
