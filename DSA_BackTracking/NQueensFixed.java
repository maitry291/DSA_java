package DSA_BackTracking;
//given constraint is that there can be put one queen in one row.
//so if array is of size n*m then no of ways for this type of combinations are columns to the power rows.
//(includes kill of queens)
//if we do this method without for loop and instead if we will give place and not place call then fixed queen in
//row constraint breaks
import static DSA_BackTracking.QueenCombination2DKill.isItSafe;

public class NQueensFixed {
    public static void main(String[] args) {
         nQueens(new boolean[4][4],0,0,"");
    }
    static int count=0;
    public static void nQueens(boolean[][] board,int row,int qpsf,String ans){
        if(qpsf== board[0].length){
            System.out.println(++count+"."+ans);
            return;
        }
        if(row== board.length)
            return;
        for(int col=0;col< board.length;col++){
            if(isItSafe(board,row,col)) { //this if statement when added only those combinations will be returned
                //which can not kill another queen.
                board[row][col] = true;
                nQueens(board, row + 1, qpsf + 1, ans + "(" + row + "," + col + ")");
                board[row][col] = false;
            }
        }
       /* //not place call
       //if it is fixed that one queen must sit in the one row then queen will not have this not place option
        nQueens(board,row,col+1,qpsf,ans);*/
    }
}
