package DSA_DynamicProgramming;

import java.util.HashMap;

public class WineProblem {
    public static void main(String[] args) {
        int[] a={2,3,5,1,4};
        int[][] s=new int[a.length][a.length];
        System.out.println(getMaxProfit(a,0,a.length-1,1));
        System.out.println(getProfitTd(a,0,a.length-1,1,s));
        /*for (int[] ints : s) {
            for (int j = 0; j < s.length; j++)
                System.out.print(ints[j] + " ");
            System.out.println();
        }*/
        System.out.println(getProfitBu(a));
    }

    //time complexity : 2^(array size)
    public static int getMaxProfit(int[] wines,int si,int li,int year){
        if(li==si)
            return wines[si]*year;

        int profit,lp,rp;

        lp=wines[si]*year+getMaxProfit(wines,si+1,li,year+1);
        rp=wines[li]*year+getMaxProfit(wines,si,li-1,year+1);

        profit=Math.max(lp,rp);

        return profit;
    }

    //time complexity : O(n^2) , space complexity : O(n^2) +  recursion extra space
    public static int getProfitTd(int[] wines,int si,int li,int year,int[][] storage){
        if(li==si)
            return wines[si]*year;
        //re use
        if(storage[si][li]!=0)
            return storage[si][li];

        int profit,lp,rp;

        lp=wines[si]*year+getMaxProfit(wines,si+1,li,year+1);
        rp=wines[li]*year+getMaxProfit(wines,si,li-1,year+1);

        profit=Math.max(lp,rp);

        storage[si][li]=profit; //store

        return profit;
    }

    //time complexity : O(array size^2) , space complexity : O(n^2)
    public static int getProfitBu(int[] wines){
        int[][] storage=new int[wines.length][wines.length];

        for(int i= storage.length-1;i>=0;i--){
            for(int j= 0;j< storage.length;j++){
                int year=storage.length-(j-i+1)+1;
                if(i==j){
                    storage[i][j]=wines[i]*wines.length;
                }
                if(j>i) {
                    storage[i][j] = Math.max(storage[i + 1][j] + wines[i] * year , wines[j] * year + storage[i][j - 1]);
                }
            }
        }
        for (int[] ints : storage) {
            for (int j = 0; j < storage.length; j++)
                System.out.print(ints[j] + " ");
            System.out.println();
        }

        return storage[0][storage.length-1];
    }


}
