package DSA.Graphs._1_Learning;

import java.util.ArrayList;

public class _2_Graph_Representation_ArrayList {
    public static void main(String[] args) {

        int n = 3;
        int m = 3;

        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

        //N + 1
        for (int i = 0; i <= n; i++) {
            arrayList.add(new ArrayList<>());
        }

        //Edge 1--2
        arrayList.get(1).add(2);
        arrayList.get(2).add(1);

        //Edge U--V
        int U = 0;
        int V = 1;
        arrayList.get(U).add(V);
        arrayList.get(V).add(U);

        //Edge 2--3
        arrayList.get(2).add(3);
        arrayList.get(3).add(2);

        //Edge 1--3
        arrayList.get(1).add(3);
        arrayList.get(3).add(1);

    }
}
