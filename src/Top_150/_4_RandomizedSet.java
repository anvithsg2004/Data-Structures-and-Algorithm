package Top_150;

import java.util.*;

public class _4_RandomizedSet {
    private Map<Integer, Integer> map; // val → index
    private List<Integer> list;
    private Random rand;

    public _4_RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        list.add(val);
        map.put(val, list.size() - 1); //This is for getting the index.
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        //Get the last inserted element and the index.
        int index = map.get(val);
        int lastElement = list.get(list.size() - 1);

        // Swap with last element
        list.set(index, lastElement);
        map.put(lastElement, index);

        // Remove last element
        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }

    public static void main(String[] args) {
        _4_RandomizedSet rs = new _4_RandomizedSet();
        System.out.println(rs.insert(1));  // true
        System.out.println(rs.remove(2));  // false
        System.out.println(rs.insert(2));  // true
        System.out.println(rs.getRandom()); // 1 or 2
        System.out.println(rs.remove(1));  // true
        System.out.println(rs.insert(2));  // false
        System.out.println(rs.getRandom()); // 2
    }
}
