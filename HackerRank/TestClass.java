package HackerRank;

import java.util.List;
import java.util.Scanner;

public class TestClass {
        public static void main(String[] args) throws Exception {
            //Sample code to perform I/O:
            Scanner s = new Scanner(System.in);
            int t,n,k,i;
            t= s.nextInt();
            for(i=0;i<t;i++)
            {
                n = s.nextInt();
                k = s.nextInt();
                while(k>n)
                {
                    k=k-n;
                }
                int [] arr = new int[n];
                for(int j=0;j<n;j++)
                {
                    arr[j] = s.nextInt();
                }
               rotateArray(arr,k);
            }
            s.close();
        }
    public static long aVeryBigSum(List<Long> ar) {
        // Write your code here
        long sum=0;
        for (Long aLong : ar) {
            sum += aLong;
        }
        return sum;
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int rd=0;
        int ld=0;
        for(int i=0,j=0;i<arr.size()&&j<arr.size();i++,j++){
            //if(i==j)
                //rd+=arr.get(i);
        }
        //return Math.abs(rd-ld);
        return 0;
    }

    public static void rotateArray(int[] a,int k){
            int[] b=new int[a.length];
            System.arraycopy(a, 0, b, 0, a.length);
            int i;
            for( i=0;i<=k&&i+k<a.length;i++)
                a[i+k]=b[i];
            for(int j=0;j<a.length&&i<a.length;j++,i++)
                a[j]=b[i];

            for (int j : a) System.out.print(j + " ");
        }
}

