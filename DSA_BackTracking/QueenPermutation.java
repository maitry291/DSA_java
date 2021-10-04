package DSA_BackTracking;
//basically this method finds all possible ways to place given num of queens in given size of array.
//count value will be equal to box.length p tq(total queens).
//for recursion tree of this method refer screenshots.
//qpsf = queens placed so far.

public class QueenPermutation {
    static int count =0;
    public static void main(String[] args) {
        boolean[] b=new boolean[4];
        NQueensPermutation(b,2,0,"");
    }
    public static void NQueensPermutation(boolean[] box,int tq,int qpsf,String ans){
        if(qpsf==tq){
            count++;
            System.out.println(count+"."+ans);
            return;
        }
        for(int i=0;i< box.length;i++){
            if(!box[i]){
                box[i]=true;
                NQueensPermutation(box, tq, qpsf+1, ans+"q"+qpsf+"b"+i+" ");
                box[i]=false; //undo part(backtracking)
            }

        }
    }
}
