package DSA_BackTracking;
//in this method we can choose any 2D size array and any number of Queens.
//in CountNQueens method number of queens are fixed which is equal to size of board that is N.

public class QueenCombination2DKill {
    public static void main(String[] args) {
        queenCombination2DKill(new boolean[4][4],0,0,3,0,"");

    }
    public static void queenCombination2DKill(boolean[][] box,int row,int col,int tq,int qpsf,String ans){
        //positive base case
        if(qpsf==tq){
            System.out.println(ans);
            return;
        }
        //negative base case
        if(row== box.length)
            return;
        //1st method-manually change variable value
        if(col==box[row].length){
            queenCombination2DKill(box,row+1,0,tq,qpsf,ans);
            return; //this is necessary.
        }
        //call for place queen if it is safe.
        if(isItSafe(box,row,col)) {
            box[row][col] = true;
            queenCombination2DKill(box, row+1, 0, tq, qpsf + 1, ans + "(" + row + "," + col + ")");
            //when we are safe to put queen in a row then there is no need to check for columns in the same row
            //we have to jump to the next row 0th column
            box[row][col] = false;
        }
        //not place queen
        queenCombination2DKill(box,row,col+1,tq,qpsf,ans);
    }
    public static boolean isItSafe(boolean[][] board,int row,int col){
       int r=row;
       int c=col-1;
       //horizontally left
       while(c>=0){
           if(board[r][c])
               return false;
           c--;
       }
       r=row-1;
       c=col;
       //vertically upward
        while(r>=0){
            if(board[r][c])
                return false;
            r--;
        }
        r=row-1;
        c=col-1;
        //diagonally left
        while(c>=0&&r>=0){
            if(board[r][c])
                return false;
            c--;
            r--;
        }
        r=row-1;
        c=col+1;
        //diagonally right
        while(c< board[0].length&&r>=0){
            if(board[r][c])
                return false;
            c++;
            r--;
        }

        return true;
    }
}
