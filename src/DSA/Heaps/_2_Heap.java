package DSA.Heaps;

import java.util.ArrayList;

public class _2_Heap {
    ArrayList<Integer> list;

    public _2_Heap() {
        list = new ArrayList<>();
    }

    public void swap(int a, int b) {
        int temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }

    public int parent(int index) {
        return (index - 1) / 2;
    }

    public int left(int index) {
        return index * 2 + 1;
    }

    public int right(int index) {
        return index * 2 + 2;
    }

    public void heapifyUp(int index) {
        if (index <= 0) {
            return;
        }

        int p = parent(index);
        if (list.get(index) < list.get(p)) {
            swap(index, p);
            heapifyUp(p);
        }
    }

    public void heapifyDown(int index) {
        int min = index;
        int left = left(index);
        int right = right(index);

        if (left < list.size() && list.get(min) > list.get(left)) {
            min = left;
        }

        if (right < list.size() && list.get(min) > list.get(right)) {
            min = right;
        }

        if (min != index) {
            swap(min, index);
            heapifyDown(min);
        }
    }

    public void insert(int value) {
        list.add(value);
        heapifyUp(list.size() - 1);
    }

    public int remove() throws Exception {
        if (list.isEmpty()) {
            throw new Exception("Removing from an Empty Heap");
        }

        int temp = list.get(0);

        int last = list.remove(list.size() - 1);
        if (!list.isEmpty()) {
            list.set(0, last);
            heapifyDown(0);
        }

        return temp;
    }

    public ArrayList<Integer> heapSort() throws Exception {
        ArrayList<Integer> data = new ArrayList<>();
        while (!list.isEmpty()) {
            data.add(this.remove());
        }
        return data;
    }
}
