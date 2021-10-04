package DSA_Recursion_Arraylist;
//SUMMARY-->>:
//Do increment, decrement, add string,add any value like operations in a function calling bracket(during recursion)
// while writing parameter name.
//When we use void data type for method which contains recursion we have to make extra parameter
//of class string and while using tht method we must pass an empty string at place of tht parameter to store the result string.

//In base case we must return the value of return data type of method.
//And doing recursion while calling function we have to store the return value of recursive function
//in return data type variable.

public class CountNQueens {
    public static void main(String[] args) {
       boolean[][] b=new boolean[4][4];
        System.out.println(getCountNQueens(b,0));
        printNQueens(b,0,"");
    }
    static int count1=0;
    public static int getCountNQueens(boolean[][] board,int row){
        if(row== board.length)
            return 1;
        int count=0;
        for(int col=0;col< board[row].length;col++){
           if(isItSafe(board,row,col)){
               board[row][col]=true;
               count=count+getCountNQueens(board,row+1);
               board[row][col]=false;
           }
        }
        return count;
    }
    public static void printNQueens(boolean[][] board, int row, String str){
        if(row== board.length) {
            System.out.println(++count1+"."+str);
            return;
        }

        for(int col=0;col< board[row].length;col++){
            if(isItSafe(board,row,col)){
                board[row][col]=true;
                printNQueens(board,row+1,str+"{"+row+","+col+"}");
                board[row][col]=false;
            }
        }
    }
    public static boolean isItSafe(boolean[][] board,int row,int col){
       for(int i=row;i>=0;i--){
           if(board[i][col])
               return false;
       }
       for(int i=row,j=col;i>=0&&j>=0;i--,j--){
           if(board[i][j])
               return false;
       }
       for(int i=row,j=col;i>=0&&j< board.length;i--,j++){
           if(board[i][j])
               return false;
       }
       return true;
    }
}
