package DSA.Graphs._3_Topo_Sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _2_Kahn_Algorithm {

    //It is just BFS version of Topo Sort

    //Algorithm :-
    //1) Maintain an In degree Array
    //2) Remove the index which has 0 value and reduce the other to which they have connected.
    //3) As I take out, put it in a Queue and at last remove and return it.
    //4) That's the answer(Topo Sort)

    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {

        int v = adj.size();

        //To calculate the In Degree.
        int[] inDegree = new int[v];

        //Traverse through the adjacency Lists and calculate the In Degree.
        for (int i = 0; i < v; i++) {
            for (int it : adj.get(i)) {
                inDegree[it]++;
            }
        }

        //First store the node which has the In Degree 0.
        Queue<Integer> queue = new LinkedList<>();
        //Store it in the queue.
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        //This is to store the topo sort and return.
        ArrayList<Integer> topo = new ArrayList<>();
        int index = 0;

        //Do the BFS.
        while (!queue.isEmpty()) {
            //Get the Queue Elements and add it to the topo ArrayList.
            int node = queue.peek();
            queue.remove();
            topo.add(index++, node);

            //Get the node and decrease the node In degree Values.
            for (int it : adj.get(node)) {
                inDegree[it]--;

                //In the middle, if you get any In Degree as 0, then add it to the queue for the next iteration.
                if (inDegree[it] == 0) {
                    queue.add(it);
                }
            }
        }

        return topo;
    }


    public static void main(String[] args) {

    }
}
