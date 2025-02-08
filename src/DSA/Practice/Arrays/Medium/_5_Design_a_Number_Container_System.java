package DSA.Practice.Arrays.Medium;

import java.util.HashMap;
import java.util.PriorityQueue;

class Pair {
    int index;
    int number;

    public Pair(int index, int number) {
        this.index = index;
        this.number = number;
    }
}

public class _5_Design_a_Number_Container_System {

    PriorityQueue<Pair> container;
    HashMap<Integer, Integer> indexMap;

    public _5_Design_a_Number_Container_System() {
        container = new PriorityQueue<>((a, b) -> Integer.compare(a.index, b.index));
        indexMap = new HashMap<>();
    }

    public void change(int index, int number) {
        //If the PQ has the index before then update.
        Pair toUpdate = null;

        for (Pair p : container) {
            if (p.index == index) {
                toUpdate = p;
                break;
            }
        }

        if (toUpdate != null) {
            container.remove(toUpdate);  //Remove an old pair
            container.add(new Pair(index, number));  //Add an updated pair
            indexMap.put(index, number);
        } else {
            //If the PQ do not have the index before then add the number.
            container.add(new Pair(index, number));
            indexMap.put(index, number);
        }
    }

    public int find(int number) {
        for (Pair p : container) {
            int index = p.index;
            int num = p.number;

            if (num == number) {
                return index;
            }

        }
        return -1;
    }

}
