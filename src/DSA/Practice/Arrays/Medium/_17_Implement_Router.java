package DSA.Practice.Arrays.Medium;

import java.util.*;

class Tuple {
    int source;
    int destination;
    int timestamp;

    public Tuple(int source, int destination, int timestamp) {
        this.source = source;
        this.destination = destination;
        this.timestamp = timestamp;
    }

    // Override equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Tuple)) return false;
        Tuple other = (Tuple) obj;
        return this.source == other.source && this.destination == other.destination && this.timestamp == other.timestamp;
    }

    // Override hashCode
    @Override
    public int hashCode() {
        return Objects.hash(source, destination, timestamp);
    }
}

public class _17_Implement_Router {

    LinkedList<Tuple> list;

    Set<Tuple> set = new HashSet<>();

    int memory;

    public _17_Implement_Router(int memoryLimit) {
        list = new LinkedList<>();
        memory = memoryLimit;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Tuple tuple = new Tuple(source, destination, timestamp);

        if (set.contains(tuple)) {
            return false; // Already present
        }

        if (list.size() >= memory) {
            Tuple removed = list.removeFirst();
            set.remove(removed);
        }

        list.addLast(tuple);
        set.add(tuple);
        return true;
    }

    public int[] forwardPacket() {

        if (!list.isEmpty()) {
            Tuple tuple = list.get(0);
            list.removeFirst();
            return new int[]{tuple.source, tuple.destination, tuple.timestamp};
        }

        return new int[]{};
    }

    public int getCount(int destination, int startTime, int endTime) {
        int count = 0;
        for (Tuple tuple : list) {
            if (tuple.destination == destination &&
                    tuple.timestamp >= startTime &&
                    tuple.timestamp <= endTime) {
                count++;
            }
        }
        return count;
    }

    public boolean isThereAnyDuplicate(List<Tuple> list, Tuple tuple) {
        return list.contains(tuple);
    }

}
