package DSA_BackTracking;
//this method gives only combinations possible(i.e. not arrangements).
//In Queens problem we are making changes in the array (i.e. in heap memory location)
// for remove that changes we have to do undo part explicitly.
//refer recursion tree of this method in ss.

public class QueenCombination {
    public static void main(String[] args) {
        boolean[] b=new boolean[4];
        NQueensCombination(b,2,0,"",-1);
    }
    static int count=0;
    public static void NQueensCombination(boolean[] box,int tq,int qpsf,String ans,int lastBoxUsed){
        if(qpsf==tq){
            count++;
            System.out.println(count+"."+ans);
            return;
        }
        for(int i=lastBoxUsed+1;i< box.length;i++){
            if(!box[i]){
                box[i]=true;
                NQueensCombination(box, tq, qpsf+1, ans+"q"+qpsf+"b"+i+" ",i);
                box[i]=false; //undo part(backtracking)
            }
        }
    }
}
