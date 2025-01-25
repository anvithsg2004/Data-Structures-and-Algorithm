package DSA.Stack_and_Queue;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

class Node1 {
    int key;
    int value;
    int freq;

    public Node1(int key, int value, int freq) {
        this.key = key;
        this.value = value;
        this.freq = 1;
    }
}

public class _18_LFU_Cache {

    int capacity;
    int minFreq;
    Map<Integer, Node1> node1Map;
    Map<Integer, LinkedHashSet<Node1>> freqMap;

    public _18_LFU_Cache(int capacity) {
        this.capacity = capacity;
        minFreq = 0;
        node1Map = new HashMap<>();
        freqMap = new HashMap<>();
    }



}
