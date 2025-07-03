import java.util.*;

class Pair {
    int node;
    int dist;

    public Pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);

        while (!pq.isEmpty()) {
            Pair p = pq.peek();
            pq.remove();
        }
    }
}
