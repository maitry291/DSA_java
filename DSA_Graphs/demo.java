package DSA_Graphs;

import java.util.HashMap;

public class demo {
    public static void main(String[] args) {
        Graph g=new Graph();
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");
        g.addVertex("E");
        g.addVertex("F");
        g.addVertex("G");
        //g.addVertex("H");

        g.addEdge("A","B",2);
        g.addEdge("A","D",6);
        g.addEdge("B","C",3);
        g.addEdge("C","D",1);
        g.addEdge("D","E",8);
        g.addEdge("E","F",5);
        g.addEdge("E","G",7);
        g.addEdge("F","G",4);

        g.display();
//        System.out.println(g.numOfEdges());
//        System.out.println(g.numOfVertices());
//        System.out.println(g.containsVertex("F"));
//        System.out.println(g.containsVertex("z"));
//        //g.removeVertex("H");
//        g.display();
//        g.removeEdge("A","B");
//        g.display();
//        System.out.println(g.containsEdge("A","B"));
//        System.out.println(g.hasPath("A","H",new HashMap<>()));
//        System.out.println(g.BFS("A","H"));
//        System.out.println(g.DFS("A","H"));
//        g.bft();
//        g.dft();
//        System.out.println(g.isCyclic());
//        System.out.println(g.isConnected());
//        System.out.println(g.isTree());
//        System.out.println(g.getCC());

        g.prims().display();
        System.out.println(g.dijkstra("A"));
        g.kruskal();
        System.out.println(g.bellmanFord("A"));
    }

}
