package HackerRank;

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

