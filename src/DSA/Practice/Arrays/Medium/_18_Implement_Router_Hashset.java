package DSA.Practice.Arrays.Medium;

import java.util.*;

class Tuple2 {
    int source;
    int destination;
    int timestamp;

    public Tuple2(int source, int destination, int timestamp) {
        this.source = source;
        this.destination = destination;
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Tuple2)) return false;
        Tuple2 other = (Tuple2) obj;
        return this.source == other.source &&
                this.destination == other.destination &&
                this.timestamp == other.timestamp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, destination, timestamp);
    }
}

class Router {

    private LinkedList<Tuple2> list;
    private Set<Tuple2> set;
    private int memory;
    private Map<Integer, TreeMap<Integer, Integer>> destinationTimestampCounts;

    public Router(int memoryLimit) {
        list = new LinkedList<>();
        set = new HashSet<>();
        memory = memoryLimit;
        destinationTimestampCounts = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Tuple2 tuple = new Tuple2(source, destination, timestamp);
        if (set.contains(tuple)) return false;

        if (list.size() >= memory) {
            Tuple2 removed = list.removeFirst();
            set.remove(removed);
            // Update destinationTimestampCounts
            TreeMap<Integer, Integer> treeMap = destinationTimestampCounts.get(removed.destination);
            if (treeMap != null) {
                int count = treeMap.get(removed.timestamp);
                if (count == 1) {
                    treeMap.remove(removed.timestamp);
                    if (treeMap.isEmpty()) {
                        destinationTimestampCounts.remove(removed.destination);
                    }
                } else {
                    treeMap.put(removed.timestamp, count - 1);
                }
            }
        }

        list.addLast(tuple);
        set.add(tuple);

        // Update destinationTimestampCounts
        TreeMap<Integer, Integer> treeMap = destinationTimestampCounts.computeIfAbsent(destination, k -> new TreeMap<>());
        treeMap.put(timestamp, treeMap.getOrDefault(timestamp, 0) + 1);

        return true;
    }

    public int[] forwardPacket() {
        Tuple2 tuple = list.pollFirst();
        if (tuple == null) return new int[]{};

        set.remove(tuple);

        // Update destinationTimestampCounts
        TreeMap<Integer, Integer> treeMap = destinationTimestampCounts.get(tuple.destination);
        if (treeMap != null) {
            int count = treeMap.get(tuple.timestamp);
            if (count == 1) {
                treeMap.remove(tuple.timestamp);
                if (treeMap.isEmpty()) {
                    destinationTimestampCounts.remove(tuple.destination);
                }
            } else {
                treeMap.put(tuple.timestamp, count - 1);
            }
        }

        return new int[]{tuple.source, tuple.destination, tuple.timestamp};
    }

    public int getCount(int destination, int startTime, int endTime) {
        TreeMap<Integer, Integer> treeMap = destinationTimestampCounts.get(destination);
        if (treeMap == null) {
            return 0;
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : treeMap.subMap(startTime, true, endTime, true).entrySet()) {
            count += entry.getValue();
        }
        return count;
    }
}
