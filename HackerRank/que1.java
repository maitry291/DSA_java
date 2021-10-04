package HackerRank;

import java.util.Scanner;

public class que1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int[] a=new int[t];
        for(int i=0;i<t;i++){
            a[i]=sc.nextInt();
        }
        int sum=0;
        for(int i=0;i<t;i++){
            sum+=a[i];
        }
        System.out.println(sum);
    }
}
