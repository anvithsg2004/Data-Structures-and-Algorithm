package DSA.Practice.Arrays.Medium;

import java.util.HashMap;
import java.util.TreeSet;

public class _5_Design_a_Number_Container_System {

    HashMap<Integer, TreeSet<Integer>> numberToIndex;
    HashMap<Integer, Integer> indexToNumber;

    public _5_Design_a_Number_Container_System() {
        numberToIndex = new HashMap<>();
        indexToNumber = new HashMap<>();
    }

    public void change(int index, int number) {
        //Delete the Old.
        if (indexToNumber.containsKey(index)) {
            int previousNumber = indexToNumber.get(index);
            numberToIndex.get(previousNumber).remove(index);
            if (numberToIndex.get(number).size() == 0) {
                numberToIndex.remove(number);
            }
        }
        //Insert the New.
        indexToNumber.put(index, number);
        if (!numberToIndex.containsKey(number)) {
            numberToIndex.put(number, new TreeSet<>());
        }
        numberToIndex.get(number).add(index);
    }

    public int find(int number) {
        if (!numberToIndex.containsKey(number)) {
            return -1;
        }
        return numberToIndex.get(number).first();
    }

}
