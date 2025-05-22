import java.util.ArrayList;
import java.util.Stack;

public class Queue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public Queue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void  helper(Stack<Integer> stack1, Stack<Integer> stack2) {

        stack2.clear();

        ArrayList<Integer> temp = new ArrayList<>();

        for (int i = 0; i < stack1.size(); i++) {
            temp.add(stack1.get(i));
        }

        for (int i = 0; i < temp.size(); i++) {
            stack2.push(temp.get(i));
        }

    }

    public void push(int a) {

        stack1.push(a);
        helper(stack1, stack2);

    }

    public int peek() {

        return stack1.peek();

    }

    public int pop() {

        return stack2.pop();

    }

    public boolean isEmpty() {

        return stack2.isEmpty();

    }

}
