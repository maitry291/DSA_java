package DSA_DynamicProgramming;

import java.util.Arrays;

public class RodCutting {
    public static void main(String[] args) {
        int n=9;
        int[] len=new int[n];
         for(int i=0;i<n;i++){
             len[i]=i;
         }
         int[] price={0,1,5,8,9,10,17,17,20};

         int[][] storage=new int[n][n];
        for(int[] r:storage){
            Arrays.fill(r,-1);
        }

        System.out.println(getProfitByRoadCutting(len,price,1,8,8));
        System.out.println(getProfitByRoadCuttingTD(len,price,1,8,8,storage));
    }

    public static int getProfitByRoadCutting(int[] len,int[] price,int si,int li,int rem_len){
        if(si== len.length||rem_len==0){
            return 0;
        }
        int ans=0;
        for(int i=si;i<len.length;i++){
            int include=0;
            if(len[i]<=rem_len){
                include=getProfitByRoadCutting(len,price,i,i,rem_len-len[i])+price[i];
            }
            int exclude=getProfitByRoadCutting(len,price,i+1,li,rem_len);

            //to update ans if profit is more
            int curr_profit=Math.max(include,exclude);

            if(curr_profit>ans)
                ans=curr_profit;
        }

        return ans;
    }
    public static int getProfitByRoadCuttingTD(int[] len,int[] price,int si,int li,int rem_len,int[][] storage){
        if(si==li||rem_len==0){
            return 0;
        }
        if(storage[si][li]!=-1){
            return storage[si][li];
        }
        int ans=0;
        for(int i=si;i<li;i++){
            int include=0;
            if(len[i]<=rem_len){
                include=getProfitByRoadCuttingTD(len,price,i,i,rem_len-len[i],storage)+price[i];
            }
            int exclude=getProfitByRoadCuttingTD(len,price,i+1,li,rem_len,storage);

            //to update ans if profit is more
            int curr_profit=Math.max(include,exclude);

            if(curr_profit>ans)
                ans=curr_profit;
        }
        storage[si][li]=ans;

        return ans;
    }
}
