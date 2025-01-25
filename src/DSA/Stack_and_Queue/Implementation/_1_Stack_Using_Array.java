package DSA.Stack_and_Queue.Implementation;

public class _1_Stack_Using_Array {

    int n = 10000;
    int[] arr = new int[n];
    int top = -1;

    public void push(int x) {
        top = top + 1;
        arr[top] = x;
    }

    public int pop() {
        int x = arr[top];
        top = top - 1;
        return x;
    }

    public int top() {
        return arr[top];
    }

    public int size() {
        return top + 1;
    }

    public boolean spaceAvailable() {
        if (top + 1 < n) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

}
