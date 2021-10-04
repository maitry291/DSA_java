package DSA_BackTracking;

public class boxRespectQueenCombination {
    public static void main(String[] args) {
        QueenComb_wrt_box(new boolean[4],2,0,"");
    }
    public static void QueenComb_wrt_box(boolean[] box,int tq,int qpsf,String ans){
        if(qpsf==tq){
            System.out.println(ans);
            return;
        }

        for(int i=0;i< box.length;i++){
            if(!box[i]){
                box[i]=true;
                QueenComb_wrt_box(box,tq,qpsf+1,ans+"b"+i);

                QueenComb_wrt_box(box,tq,qpsf,ans);
                box[i]=false;
                break;
            }
        }
        //second method
        /*
        f(box,col,tq,qpsf,ans)
        needs negative base case also
        if(col==box.length)
        return;
        box[col]=true;
        QueenComb_wrt_box(box,col+1,tq,qpsf+1,ans+"b"+col);
        box[i]=false;
        QueenComb_wrt_box(box,col+1,tq,qpsf,ans);
        */

    }
}
