package DSA_BackTracking;
//element containing 1 is blocked path.

public class Blocked_MazePath {
    public static void main(String[] args) {
        int[][] m={{0,1,0,0},{0,0,0,0},{0,1,0,0},{0,0,1,0}};
        blockedMaze(m,0,0,"",new boolean[m.length][m[0].length]);
    }
    public static void blockedMaze(int[][] maze,int row,int col,String ans,boolean[][] visited){
        //positive bc
        if(row== maze.length-1&&col== maze[0].length-1){
            System.out.println(ans);
            return;
        }
        //negative bc
        if(row<0||col<0||row== maze.length||col== maze[0].length||maze[row][col]==1||visited[row][col])
            return;

        //put a mark(to prevent going to same path again)
        visited[row][col]=true;
        //top
        blockedMaze(maze,row-1,col,ans+"T",visited);
        //down
        blockedMaze(maze,row+1,col,ans+"D",visited);
        //left
        blockedMaze(maze,row,col-1,ans+"L",visited);
        //right
        blockedMaze(maze,row,col+1,ans+"R",visited);

        visited[row][col]=false;  //undo part
    }
}
