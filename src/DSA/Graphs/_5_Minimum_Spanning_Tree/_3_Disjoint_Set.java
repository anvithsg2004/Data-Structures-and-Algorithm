package DSA.Graphs._5_Minimum_Spanning_Tree;

//Disjoint Set
//For Example :-
//We have two components 1->2->3->4 and 5->6->7. Now the question is does 1 and 5 belong to the same component or not?
//Basically I do is that I do a simple DFS/BFS which basically take O(V + E).
//But the Disjoint Set will do in constant time complexity.
//Usually used dynamic Graphs
//Has two functionality is
//1) Find the Parent.
//2) Find union by rank and size.

//To find the parent, we have to find the ultimate parent.

//Here union means there are two nodes 1 and 2.
//If say union then connect 1 and 2 == 1->2

//Union(u, v)
//Steps :-
//1) Find the ultimate parent of u and v named as pu and pv.
//2) Find the rank of pu and pv.
//3) Connect the smaller rank to larger rank always.
//   If the rank of both is equal, then you can connect to anyone.
// Time Complexity = O(4 * alpha)

//Path Compression
// So imagine (3) -> (2) -> (1)
// In the above graph (3) ultimate parent is (1).
// So instead of traversing from (3) to (1), change it to (2) -> (1) <- (3).
//This will reduce the time.

public class _3_Disjoint_Set {
}
