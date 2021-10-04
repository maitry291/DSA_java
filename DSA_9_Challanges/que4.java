package DSA_9_Challanges;

public class que4 {
    public static void main(String[] args) {
         char[][] maze={{'o','x','o','o'},{'o','o','o','x'},{'o','o','x','o'},
                 {'x','o','o','o'},{'x','x','o','o'}};
         ratInMaze(maze,0,0,new int[maze.length][maze[0].length]);
    }
    public static void ratInMaze(char[][] grid,int row,int col,int[][] ans){
        //positive bc
        if(row==grid.length-1&&col== grid[0].length){
            for (int[] an : ans) {
                for (int j = 0; j < ans[0].length; j++) {
                    System.out.print(an[j] + " ");
                }
                System.out.println();
            }
            return;
        }
        //negative bc
        if(row== grid.length||col==grid[0].length||ans[row][col]==1||grid[row][col]=='x')
            return;
        if(row< grid.length-1&&col< grid[0].length&&grid[row+1][col]=='x'&&grid[row][col+1]=='x')
            return;

        //make path
        ans[row][col]=1;
        //if(grid[row][col+1]!='x')
        ratInMaze(grid,row,col+1,ans);

       // if(grid[row+1][col]!='x')
        ratInMaze(grid,row+1,col,ans);
        //ans[row][col]=0;
    }
}
