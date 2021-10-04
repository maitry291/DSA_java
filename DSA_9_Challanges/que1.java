package DSA_9_Challanges;

import java.util.Scanner;

public class que1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            int digit=sc.nextInt();
            countNum(digit,"");
        }
    }
    public static void countNum(int digit,String ans){
        if(digit==0){
            System.out.println(ans);
            return;
        }
        countNum(digit-1,ans+"a");
        if(ans.isEmpty()||ans.charAt(ans.length()-1)!='b')
           countNum(digit-1,ans+"b");

    }
}
