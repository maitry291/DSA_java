package DSA_Graphs;

//this algo uses dynamic programming
//this algo gives all vertex's shortest path in a 2d matrix form
//O(V^3)
public class FloydWarshall {

    public static void main(String[] args) {
        int[][] graph={{0,3,10000,7},{8,0,2,10000},{5,10000,0,1},{2,10000,10000,0}};

        int l= graph.length;;
        int[][] dist=new int[l][l];

        //copying elements
        for(int i=0;i<l;i++){
            System.arraycopy(graph[i], 0, dist[i], 0, graph[0].length);
        }

        for(int k=0;k<l;k++){
            for(int i=0;i<l;i++){
                for(int j=0;j<l;j++){
                    int oc=dist[i][j];
                    int nc=dist[i][k]+dist[k][j];
                    if(nc<oc){
                        dist[i][j]=nc;
                    }
                }
            }
        }
        for(int k=0;k<l;k++) {
            for (int i = 0; i < l; i++) {
                System.out.print(dist[k][i]+" ");
            }
            System.out.println();
        }

    }

}
