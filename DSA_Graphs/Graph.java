package DSA_Graphs;

import DSA_Heap.Heap;
import DSA_Heap.HeapGeneric;

import javax.management.StringValueExp;
import java.util.*;

public class Graph {
    //each vertex of graph will have some neighbour vertices
    //to store them we will need a hashmap of string to integer
    //string/key will contain name of the vertex and integer/value will contain cost of the edge
    private static class Vertex {
        HashMap<String, Integer> neighbours = new HashMap<>();
    }

    //graph have its own properties too ,one of them is vertices
    //to store vertices we need hashmap of string to object of class vertex
    //string/key will contain name of the vertex and object of class vertex will contain neighbour vertices.
    HashMap<String, Vertex> vertices;

    public Graph() {
        this.vertices = new HashMap<>();
    }

    //O(1)
    public int numOfVertices() {
        return this.vertices.size();
    }

    //O(1)
    public boolean containsVertex(String v) {
        return this.vertices.containsKey(v);
    }

    //O(1)
    public void addVertex(String v) {
        this.vertices.put(v, new Vertex());
    }

    //O(V)
    public int numOfEdges() {
        int count = 0;
        //we are storing all vertex in an arraylist and then applying for each loop on each vertex and then
        //getting the hashmap of neighbours then adding its size
        //this count will have value double of total edges.
        ArrayList<String> keys = new ArrayList<>(this.vertices.keySet());
        for (String key : keys) {
            Vertex v = vertices.get(key);
            count += v.neighbours.size();
        }
        return count / 2;
    }

    //O(1)
    public boolean containsEdge(String v1Name, String v2Name) {
        Vertex v1 = vertices.get(v1Name);
        Vertex v2 = vertices.get(v2Name);
        return v1 != null && v2 != null && v1.neighbours.containsKey(v2Name);
    }

    //O(1)
    public void addEdge(String v1Name, String v2Name, int cost) {
        Vertex v1 = vertices.get(v1Name);
        Vertex v2 = vertices.get(v2Name);
        if (v1 == null && v2 == null && !v1.neighbours.containsKey(v2Name)) {
            return;
        }
        v1.neighbours.put(v2Name, cost);
        v2.neighbours.put(v1Name, cost);
    }

    //O(1)
    public void removeEdge(String v1Name, String v2Name) {
        Vertex v1 = vertices.get(v1Name);
        Vertex v2 = vertices.get(v2Name);
        if (v1 == null && v2 == null && !v1.neighbours.containsKey(v2Name)) {
            return;
        }
        v1.neighbours.remove(v2Name);
        v2.neighbours.remove(v1Name);
    }

    public void removeVertex(String vName) {
        Vertex v = vertices.get(vName);
        ArrayList<String> keys = new ArrayList<>(v.neighbours.keySet());
        for (String key : keys) {
            Vertex nbrVrtx = vertices.get(key);
            nbrVrtx.neighbours.remove(vName);
        }
        vertices.remove(vName);
    }

    //O(V)
    public void display() {
        System.out.println("----------------------------------------------");
        ArrayList<String> keys = new ArrayList<>(vertices.keySet());

        for (String key : keys) {
            Vertex v = vertices.get(key);
            System.out.println(key + " : " + v.neighbours);
        }
        System.out.println("----------------------------------------------");

    }

    public boolean hasPath(String v1Name, String v2Name, HashMap<String, Boolean> checked) {
        //base case
        if (containsEdge(v1Name, v2Name))
            return true;

        Vertex v1 = vertices.get(v1Name);   //2k address
        //Vertex v2 = vertices.get(v2Name);   //4k address
        checked.put(v1Name, true);

        ArrayList<String> keys = new ArrayList<>(v1.neighbours.keySet());
        for (String key : keys) {
            if (!checked.containsKey(key) && hasPath(key, v2Name, checked))
                return true;
        }
        return false;
    }

    public static class Pair {
        String vName;
        String psf; //path so far
    }

    //O(V+E)
    //we traverse as per level order in bfs, so we will get the shortest path
    public Boolean BFS(String src, String dst) {
        HashMap<String, Boolean> checked = new HashMap<>();
        //in ll complexity of remove first and add last method is in order of 1 i.e. constant that's why we used ll
        LinkedList<Pair> queue = new LinkedList<>();

        //create a new pair
        Pair p = new Pair();
        p.vName = src;
        p.psf = src;

        queue.addLast(p);

        while (!queue.isEmpty()) {
            //remove pair from queue
            Pair rp = queue.removeFirst();

            //check for repeat vertex
            if (checked.containsKey(rp.vName))
                continue;

            //check in hash map
            checked.put(rp.vName, true);

            //check for direct edge
            if (containsEdge(rp.vName, dst)) {
                System.out.println(rp.psf + dst);
                return true;
            }

            //else check for neighbour vertices
            Vertex v = vertices.get(rp.vName);
            ArrayList<String> keys = new ArrayList<>(v.neighbours.keySet());
            //till here we do steps for each vertex so overall v times

            //loop on neighbours
            //total number of nbrs are twice of total edges
            for (String key : keys) {
                //check path for unchecked elements in hash map
                if (!checked.containsKey(key)) {
                    //make a new pair of key and add in the queue
                    Pair np = new Pair();
                    np.vName = key;
                    np.psf = rp.psf + key;
                    queue.addLast(np);
                }
            }

        }
        return false;
    }

    //O(V+E)
    //difference between code of bfs and dfs is only of data structure we are using to store the node
    //in bfs we use queue and in dfs we use stack
    //only bfs gives us the shortest path...dfs don't give the shortest path alws
    //in dfs we traverse according to the depth i.e. if we take one node then all the child nodes of that node are traversed first then
    //comes its sibling.
    public boolean DFS(String src, String dst) {
        HashMap<String, Boolean> checked = new HashMap<>();
        //in ll complexity of remove first and add first method is in order of 1 i.e. constant that's why we used ll
        //remove first and add first are functions to implement stack.
        LinkedList<Pair> stack = new LinkedList<>();

        //create a new pair
        Pair p = new Pair();
        p.vName = src;
        p.psf = src;

        stack.addFirst(p);

        while (!stack.isEmpty()) {
            //remove pair from stack
            Pair rp = stack.removeFirst();

            //check for repeat vertex
            if (checked.containsKey(rp.vName))
                continue;

            //check in hash map
            checked.put(rp.vName, true);


            //check for direct edge
            if (containsEdge(rp.vName, dst)) {
                System.out.println(rp.psf + dst);
                return true;
            }

            //else check for neighbour vertices
            Vertex v = vertices.get(rp.vName);
            ArrayList<String> keys = new ArrayList<>(v.neighbours.keySet());

            //O(E)
            //loop on neighbours
            for (String key : keys) {
                //check path for unchecked elements in hash map
                if (!checked.containsKey(key)) {
                    //make a new pair of key and add in the stack
                    Pair np = new Pair();
                    np.vName = key;
                    np.psf = rp.psf + key;
                    stack.addFirst(np);
                }
            }

        }
        return false;
    }

    //O(V+E)
    //breadth first traversal
    public void bft() {
        HashMap<String, Boolean> checked = new HashMap<>();
        //in ll complexity of remove first and add last method is in order of 1 i.e. constant that's why we used ll
        LinkedList<Pair> queue = new LinkedList<>();
        ArrayList<String> keys = new ArrayList<>(vertices.keySet());

        //we will do whole process for each key i.e. each vertex
        for (String key : keys) {
            //this condition is for the graphs which have more than one component ,or we can say disconnected graph
            if (checked.containsKey(key))
                continue;
            //create a new pair
            Pair p = new Pair();
            p.vName = key;
            p.psf = key;

            queue.addLast(p);

            while (!queue.isEmpty()) {
                //remove pair from queue
                Pair rp = queue.removeFirst();

                //check for repeat vertex
                if (checked.containsKey(rp.vName))
                    continue;

                //check in hash map
                checked.put(rp.vName, true);


                //will print path
                System.out.println(rp.vName + " " + rp.psf);

                //else check for neighbour vertices
                Vertex v = vertices.get(rp.vName);
                ArrayList<String> nbrs = new ArrayList<>(v.neighbours.keySet());

                //loop on neighbours
                for (String nbr : keys) {
                    //check path for unchecked elements in hash map
                    if (!checked.containsKey(nbr)) {
                        //make a new pair of nbrs and add in the queue
                        Pair np = new Pair();
                        np.vName = nbr;
                        np.psf = rp.psf + nbrs;
                        queue.addLast(np);
                    }
                }
            }
        }
    }

    //O(V+E)
    //depth first traversal
    public void dft() {
        HashMap<String, Boolean> checked = new HashMap<>();
        //in ll complexity of remove first and add last method is in order of 1 i.e. constant that's why we used ll
        LinkedList<Pair> stack = new LinkedList<>();
        ArrayList<String> keys = new ArrayList<>(vertices.keySet());

        //we will do whole process for each key i.e. each vertex
        for (String key : keys) {
            //this condition is for the graphs which have more than one component ,or we can say disconnected graph
            if (checked.containsKey(key))
                continue;
            //create a new pair
            Pair p = new Pair();
            p.vName = key;
            p.psf = key;

            stack.addFirst(p);

            while (!stack.isEmpty()) {
                //remove pair from stack
                Pair rp = stack.removeFirst();

                //check for repeat vertex
                if (checked.containsKey(rp.vName))
                    continue;

                //check in hash map
                checked.put(rp.vName, true);


                //will print path
                System.out.println(rp.vName + " " + rp.psf);

                //else check for neighbour vertices
                Vertex v = vertices.get(rp.vName);
                ArrayList<String> nbrs = new ArrayList<>(v.neighbours.keySet());

                //loop on neighbours
                for (String nbr : keys) {
                    //check path for unchecked elements in hash map
                    if (!checked.containsKey(nbr)) {
                        //make a new pair of nbrs and add in the stack
                        Pair np = new Pair();
                        np.vName = nbr;
                        np.psf = rp.psf + nbrs;
                        stack.addFirst(np);
                    }
                }
            }
        }
    }

    //O(V+E)
    //if graph has any cycle then this will return true
    public boolean isCyclic() {
        HashMap<String, Boolean> checked = new HashMap<>();
        //in ll complexity of remove first and add last method is in order of 1 i.e. constant that's why we used ll
        LinkedList<Pair> queue = new LinkedList<>();
        ArrayList<String> keys = new ArrayList<>(vertices.keySet());

        //we will do whole process for each key i.e. each vertex
        for (String key : keys) {
            //this condition is for the graphs which have more than one component ,or we can say disconnected graph
            if (checked.containsKey(key))
                continue;
            //create a new pair
            Pair p = new Pair();
            p.vName = key;
            p.psf = key;

            queue.addLast(p);

            while (!queue.isEmpty()) {
                //remove pair from queue
                Pair rp = queue.removeFirst();

                //check for repeat vertex
                if (checked.containsKey(rp.vName))
                    return true;

                //check in hash map
                checked.put(rp.vName, true);

                //else check for neighbour vertices
                Vertex v = vertices.get(rp.vName);
                ArrayList<String> nbrs = new ArrayList<>(v.neighbours.keySet());

                //loop on neighbours
                for (String nbr : keys) {
                    //check path for unchecked elements in hash map
                    if (!checked.containsKey(nbr)) {
                        //make a new pair of nbrs and add in the queue
                        Pair np = new Pair();
                        np.vName = nbr;
                        np.psf = rp.psf + nbrs;
                        queue.addLast(np);
                    }
                }
            }
        }
        return false;
    }

    //O(V+E)
    //if graph is connected then thus will return true
    public boolean isConnected() {
        int flag = 0;
        HashMap<String, Boolean> checked = new HashMap<>();
        //in ll complexity of remove first and add last method is in order of 1 i.e. constant that's why we used ll
        LinkedList<Pair> queue = new LinkedList<>();
        ArrayList<String> keys = new ArrayList<>(vertices.keySet());

        //we will do whole process for each key i.e. each vertex
        for (String key : keys) {
            //this condition is for the graphs which have more than one component ,or we can say disconnected graph
            if (checked.containsKey(key))
                continue;
            flag++;
            //create a new pair
            Pair p = new Pair();
            p.vName = key;
            p.psf = key;

            queue.addLast(p);

            while (!queue.isEmpty()) {
                //remove pair from queue
                Pair rp = queue.removeFirst();

                //check for repeat vertex
                if (checked.containsKey(rp.vName))
                    continue;

                //check in hash map
                checked.put(rp.vName, true);

                //else check for neighbour vertices
                Vertex v = vertices.get(rp.vName);
                ArrayList<String> nbrs = new ArrayList<>(v.neighbours.keySet());

                //loop on neighbours
                for (String nbr : keys) {
                    //check path for unchecked elements in hash map
                    if (!checked.containsKey(nbr)) {
                        //make a new pair of nbrs and add in the queue
                        Pair np = new Pair();
                        np.vName = nbr;
                        np.psf = rp.psf + nbrs;
                        queue.addLast(np);
                    }
                }
            }
        }
        return flag <= 1;
    }

    //O(V+E)
    //graph can be said tree if it is acyclic and connected
    //tree will always have n-1 edges
    public boolean isTree() {
        return !isCyclic() && isConnected();
    }

    //O(V+E)
    //to get all disconnected components members in an individual list
    public ArrayList<ArrayList<String>> getCC() {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        HashMap<String, Boolean> checked = new HashMap<>();
        //in ll complexity of remove first and add last method is in order of 1 i.e. constant that's why we used ll
        LinkedList<Pair> queue = new LinkedList<>();
        ArrayList<String> keys = new ArrayList<>(vertices.keySet());

        //we will do whole process for each key i.e. each vertex
        for (String key : keys) {
            //to get list
            ArrayList<String> subans = new ArrayList<>();
            //this condition is for the graphs which have more than one component ,or we can say disconnected graph
            if (checked.containsKey(key))
                continue;
            //create a new pair
            Pair p = new Pair();
            p.vName = key;
            p.psf = key;

            queue.addLast(p);

            while (!queue.isEmpty()) {
                //remove pair from queue
                Pair rp = queue.removeFirst();

                //check for repeat vertex
                if (checked.containsKey(rp.vName))
                    continue;

                //check in hash map
                checked.put(rp.vName, true);

                //add vertex in subans
                subans.add(rp.vName);

                //else check for neighbour vertices
                Vertex v = vertices.get(rp.vName);
                ArrayList<String> nbrs = new ArrayList<>(v.neighbours.keySet());

                //loop on neighbours
                for (String nbr : keys) {
                    //check path for unchecked elements in hash map
                    if (!checked.containsKey(nbr)) {
                        //make a new pair of nbrs and add in the queue
                        Pair np = new Pair();
                        np.vName = nbr;
                        np.psf = rp.psf + nbrs;
                        queue.addLast(np);
                    }
                }
            }
            ans.add(subans);
        }
        return ans;
    }

    private static class PrimsPair implements Comparable<PrimsPair> {
        String vName;
        String acqVName;
        int cost;

        @Override
        public int compareTo(PrimsPair o) {
            return o.cost - this.cost;
        }
    }

    //O(E*log(V))
    public Graph prims() {
        Graph mst = new Graph();
        HashMap<String, PrimsPair> map = new HashMap<>();
        HeapGeneric<PrimsPair> heap = new HeapGeneric<>();

        //O(V*log(V))
        for (String key : vertices.keySet()) {
            PrimsPair np = new PrimsPair();
            np.vName = key;
            np.cost = Integer.MAX_VALUE;
            np.acqVName = null;

            heap.add(np); //O(log(V))
            map.put(key, np);
        }

        //till the heap is not empty keep removing pairs
        while (!heap.isEmpty()) { //loop will run for v times
            //remove a pair
            PrimsPair rp = heap.remove();  //O(log(V))
            map.remove(rp.vName);

            //add to mst
            if (rp.acqVName == null) {
                mst.addVertex(rp.vName);
            } else {
                mst.addVertex(rp.vName);
                mst.addEdge(rp.vName, rp.acqVName, rp.cost);
            }

            //O(2E*log(V)) ->order of E*log(V)
            //to get acquiring vertices of a vertex
            for (String nbr : vertices.get(rp.vName).neighbours.keySet()) {

                if (map.containsKey(nbr)) {
                    int oc = map.get(nbr).cost;
                    int nc = vertices.get(rp.vName).neighbours.get(nbr);

                    if (nc < oc) {
                        PrimsPair pair = map.get(nbr);
                        pair.acqVName = rp.vName;
                        pair.cost = nc;
                        //important -- after changing cost of any node in heap we have to arrange it again
                        //according to priority
                        heap.updateHeap(pair);  //O(log(V))
                    }
                }
            }

        }

        return mst;
    }

    private static class DijkstraPair implements Comparable<DijkstraPair> {
        String vName;
        String psf;
        int cost;

        @Override
        public int compareTo(DijkstraPair o) {
            return o.cost - this.cost;
        }
    }

    //O(E*log(V)) similar to prims
    //returns a hashmap of containing min distance of all vertex with src
    public HashMap<String, Integer> dijkstra(String src) {

        HashMap<String, Integer> ans = new HashMap<>();
        HashMap<String, DijkstraPair> map = new HashMap<>();
        HeapGeneric<DijkstraPair> heap = new HeapGeneric<>();

        //putting all vertex in heap as dijkstra pair with cost infinity and psf null
        for (String key : vertices.keySet()) {
            DijkstraPair np = new DijkstraPair();
            np.vName = key;
            np.cost = Integer.MAX_VALUE;
            np.psf = "";

            if (Objects.equals(key, src)) {
                np.psf = src;
                np.cost = 0;
            }

            heap.add(np);
            map.put(key, np);
        }

        //till the heap is not empty keep removing pairs
        while (!heap.isEmpty()) {
            //remove a pair from minHeap, so we will get the vertex having min cost value
            DijkstraPair rp = heap.remove();
            map.remove(rp.vName);

            //add to ans hashmap
            ans.put(rp.vName, rp.cost);

            //to get psf of a vertex we need to get nbrs of that vertex
            for (String nbr : vertices.get(rp.vName).neighbours.keySet()) {

                if (map.containsKey(nbr)) {
                    int oc = map.get(nbr).cost;
                    int nc = rp.cost + vertices.get(rp.vName).neighbours.get(nbr);

                    if (nc < oc) {
                        DijkstraPair pair = map.get(nbr);
                        pair.psf = rp.psf + rp.vName;
                        pair.cost = nc;
                        //important -- after changing cost of any node in heap we have to arrange it again
                        //according to priority
                        heap.updateHeap(pair);
                    }
                }
            }

        }

        return ans;
    }

    //disjoint sets means set can not have any element in common.
    public static class DisjointSet {

        HashMap<String, Node> map = new HashMap<>();

        private static class Node {
            String data;
            Node parent;
            int rank;
        }

        public void create(String value) {
            Node nn = new Node();
            nn.data = value;
            nn.parent = nn;
            nn.rank = 0;

            map.put(value, nn);
        }

        public void union(String v1, String v2) {
            Node n1 = findSet(map.get(v1));
            Node n2 = findSet(map.get(v2));

            if (!n1.equals(n2)) {
                if (n1.rank == n2.rank) {
                    n2.parent = n1;
                    n1.rank++;
                }
                if (n1.rank > n2.rank) {
                    n2.parent = n1;
                }
                if (n1.rank < n2.rank) {
                    n1.parent = n2;
                }
            }
        }

        public String findSet(String value) {
            return findSet(map.get(value)).data;
        }

        private Node findSet(Node node) {
            if (node == node.parent)
                return node;
            return findSet(node.parent);
        }

    }

    private static class EdgePair implements Comparable<EdgePair> {
        String v1;
        String v2;
        int cost;

        @Override
        public int compareTo(EdgePair o) {
            return this.cost - o.cost;
        }

        public String toString() {
            return v1 + "-" + v2 + "->" + cost;
        }

    }

    //O(VE) ?
    public ArrayList<EdgePair> getAllEdges() {
        ArrayList<EdgePair> edges = new ArrayList<>();

        for (String v : vertices.keySet()) {
            //each vertex have neighbour(means an edge between them) vertex hashmap
            for (String key : vertices.get(v).neighbours.keySet()) {
                EdgePair ep = new EdgePair();
                ep.v1 = v;
                ep.v2 = key;
                ep.cost = vertices.get(v).neighbours.get(key);
                edges.add(ep);
            }
        }
        return edges;
    }

    //O(E*log(E))  or in worst case E=V^2 ,so O(E*log(V))
    //returns same mst as prims algo
    public void kruskal() {
        //get all edges then sort the list in increasing order
        ArrayList<EdgePair> edges = getAllEdges();  //O(VE) this is not considered why?
        Collections.sort(edges);  //O(E*log(E))
        //System.out.println(edges);

        DisjointSet set = new DisjointSet();
        //we will create set for each vertex
        for (String vtx : vertices.keySet()) {  //O(V)
            set.create(vtx);
        }

        //traverse over edge
        for (EdgePair edge : edges) {
            String re1 = set.findSet(edge.v1); //re1=representative element
            String re2 = set.findSet(edge.v2);

            if (!re1.equals(re2)) {
                System.out.println(edge);
                set.union(re1, re2);
            }
        }

    }

    //O(V*E)
    //this function returns similar value as dijkstra but the diff is that dijkstra won't work
    //if any edge have -ve cost value but bell man ford works
    //bell man ford and dijkstra both algo fails when graph contains any -ve weight cycle
    public HashMap<String, Integer> bellmanFord(String src) {
        HashMap<String, Integer> ans = new HashMap<>();
        //step 2-get all edges
        ArrayList<EdgePair> edges = getAllEdges();
        //step 1 - get map of all vertex
        for (String vtx : vertices.keySet()) {
            if (Objects.equals(vtx, src))
                ans.put(vtx, 0);
            //not giving value as integer.max coz when we add in int.max the value will be out of range
            else
                ans.put(vtx, 100000);
        }
        //step 3 -relaxation
        //it is done v-1 times coz any vertex will be at max v-1 distance far from source in worst case
        for(int i=0;i<vertices.size();i++){
            for(EdgePair ep:edges) {
                int oc=ans.get(ep.v2);
                int nc=ans.get(ep.v1)+ ep.cost;
                if (oc>nc){
                    if(i==vertices.size()-1){
                        System.out.println("Negative weight cycle is present");
                    }
                    ans.put(ep.v2,nc);
                }
            }
        }

        return ans;
    }


}
