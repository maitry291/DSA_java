package DSA_7_Challanges;

import java.util.Scanner;

public class ques1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println(isSorted(a,0));
    }
    public static boolean isSorted(int[] a,int si){
        boolean b;
        if(si==a.length-1)
            return true;
        if(a[si]>a[si+1])
            return false;
        else{
          return isSorted(a,si+1);
        }
    }

}
