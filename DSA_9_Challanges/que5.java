package DSA_9_Challanges;

import java.util.ArrayList;
import java.util.Arrays;

public class que5 {
    public static void main(String[] args) {
        int[] a={10,1,2,7,6,1,5};
        maxSumCombinations(a,8,0,"");
    }
    //static ArrayList<Integer> comb=new ArrayList<>();

    public static void maxSumCombinations(int[] a,int max_sum,int si,String ans){
       // Arrays.sort(a);
        if(max_sum==0){
            System.out.println(ans);
            return;
        }
        if(max_sum<0||si==a.length)
            return;

        maxSumCombinations(a,max_sum-a[si],si+1,ans+" "+a[si]);
        maxSumCombinations(a,max_sum,si+1,ans);
    }
}
