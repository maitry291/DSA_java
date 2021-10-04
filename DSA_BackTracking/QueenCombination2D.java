package DSA_BackTracking;
//this combination will be given w.r.t. box.
//this method only gives combination, queens can be killed by another queen in any combination.

public class QueenCombination2D {
    public static void main(String[] args) {
          queenCombination2D(new boolean[4][4],0,0,4,0,"");
    }
    static int count=0;
    public static void queenCombination2D(boolean[][] box,int row,int col,int tq,int qpsf,String ans){
        //positive base case
        if(qpsf==tq){
            System.out.println(++count+"."+ans);
            return;
        }
        //1st method-manually change variable value
        if(col==box[row].length){
            row++;
            col=0; //after this statement we can't write return statement
            //coz we want to execute statement below this block.
        }
        //negative base case
        if(row== box.length)  //if we use second method then this block should come before recursion call.
            //As shown in 2D kill code.
            return;

       /* //2nd method-give extra recursive call
        if(col==box[row].length){
           queenCombination2D(box,row+1,0,tq,qpsf,ans);
           return; //this is necessary.
        }*/
        //call for place queen
        box[row][col]=true;
        queenCombination2D(box,row,col+1,tq,qpsf+1,ans+"("+row+","+col+")");
        box[row][col]=false;
        //not place queen
        queenCombination2D(box,row,col+1,tq,qpsf,ans);
    }
}
