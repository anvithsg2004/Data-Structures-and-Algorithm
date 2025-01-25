package DSA.Stack_and_Queue;

import java.util.Stack;

//This is an implementation problem.

class Pair {
    int value;
    int minimum;

    public Pair(int value, int minimum) {
        //This will store the current value.
        this.value = value;
        //This stores the minimum number of the entire stack.
        this.minimum = minimum;
    }
}

public class _2_Implement_Min_Stack {

    public Stack<Pair> minStack;

    public _2_Implement_Min_Stack() {
        minStack = new Stack<>();
    }

    public void push(int val) {

        //If the stack is empty, then fill the given values as the first value and the minimum.
        if (minStack.isEmpty()) {
            minStack.push(new Pair(val, val));
        } else {
            //If not, then put the value and get the minimum of the last and compare with the current value
            //and put it to the stack.
            minStack.push(new Pair(val, Math.min(val, minStack.peek().minimum)));
        }

    }

    public void pop() {
        if (!minStack.isEmpty()) {
            minStack.pop();
        }
    }

    public int top() {
        if (!minStack.isEmpty()) {
            return minStack.peek().value;
        } else {
            return -1;
        }
    }

    public int getMin() {

        if (!minStack.isEmpty()) {
            return minStack.peek().minimum;
        } else {
            return -1;
        }

    }

}
