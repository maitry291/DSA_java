package DSA_BackTracking;
//knights can take only 2.5 steps i.e. 2 horizontal and 1 vertical or vice versa.

public class NKnights {
    public static void main(String[] args) {
        NKnights2D(new boolean[3][3],0,0,0,"");
    }
    static int count=0;
    public static void NKnights2D(boolean[][] board,int row,int col,int kpsf,String ans){
        //positive base case
        if(kpsf==board.length){
            System.out.println(++count+"."+ans);
            return;
        }
        //1st method-manually change variable value
        if(col==board[row].length){
            row++;
            col=0; //after this statement we can't write return statement
            //coz we want to execute statement below this block.
        }
        //negative base case
        if(row== board.length)
            return;
        //place knight if it is safe
        if(isItSafeToPlaceKnight(board,row,col)) {
            board[row][col] = true;
            NKnights2D(board, row, col + 1, kpsf + 1, ans + "(" + row + "," + col + ")");
            board[row][col] = false;
        }
        //not place knight
        NKnights2D(board,row,col+1,kpsf,ans);
    }
    public static boolean isItSafeToPlaceKnight(boolean[][] board,int row,int col){
        int[] rowArray={-1,-2,-2,-1};
        int[] colArray={2,1,-1,-2};
        for(int i=0;i<4;i++){
            int r=row+rowArray[i];
            int c=col+colArray[i];
            if(r>=0&&c>=0&&r< board.length&&c< board.length){
                if(board[r][c])
                    return false;
            }
        }
        return true;
    }

}
