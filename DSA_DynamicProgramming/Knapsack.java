package DSA_DynamicProgramming;

import java.util.Arrays;

public class Knapsack {
    public static void main(String[] args) {
        int[] wt={1,3,4,5};
        int[] p={1,4,5,7};
        int c=7;
        int[][] storage=new int[wt.length][c+1];

        System.out.println(getMaxProfit(wt,p,7,0));
        System.out.println(getMaxProfitTd(wt,p,c,0,storage));

        System.out.println(getMaxProfitBu(wt,p,c));
    }

    //time complexity : O(2^n*cap)  not sure
    public static int getMaxProfit(int[] wt,int[] price,int cap,int si){
        //base case
        if(si == wt.length||cap==0)
            return 0;

        //two cae
        //1.we include si wt and profit
        int profit1 = 0;
        if(cap>=wt[si])
        profit1=getMaxProfit(wt,price,cap-wt[si],si+1)+price[si];
        //1.we exclude si wt and profit
        int profit2=getMaxProfit(wt,price,cap,si+1);

        //return max profit
        return Math.max(profit1,profit2);
    }

    //time complexity : O(n*cap) and space complexity : O(n*cap)+recursion extra space
    public static int getMaxProfitTd(int[] wt, int[] price, int cap, int si,int[][] storage) {
        //base case
        if (si == wt.length || cap == 0)
            return 0;
        if(storage[si][cap]!=0)
            return storage[si][cap];

        //two cae
        //1.we include si wt and profit
        int profit1 = 0;
        if (cap >= wt[si])
            profit1 = getMaxProfitTd(wt, price, cap - wt[si], si + 1,storage) + price[si];
        //1.we exclude si wt and profit
        int profit2 = getMaxProfitTd(wt, price, cap, si + 1,storage);

        //return max profit
        int ans=Math.max(profit1, profit2);
        storage[si][cap]=ans;
        return ans;
    }

    //time complexity : O(n*cap) and space complexity : O(n*cap)
    public static int getMaxProfitBu(int[] wt, int[] price, int cap){
        int n=wt.length;
        int[][] storage=new int[n+1][cap+1];

        for(int row=n-1;row>=0;row--){
            for(int col=1;col<=cap;col++){
                int exclude=storage[row+1][col];
                int include=0;
                if(col>=wt[row])
                include=storage[row+1][col-wt[row]]+price[row];

                int ans=Math.max(exclude,include);

                storage[row][col]=ans;
            }
        }
        for(int[] a:storage)
            System.out.println(Arrays.toString(a));
        return storage[0][cap];
    }



}
