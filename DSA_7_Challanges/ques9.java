package DSA_7_Challanges;

import java.util.Scanner;

public class ques9 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
           String str=sc.nextLine();
           replaceAllPI(str);
        }
        System.out.println(replaceAllPi("abcpigvgtd",0));
    }
    public static void replaceAllPI(String str){
        if(str.contains("pi")){
            str=str.replaceAll("pi","3.14");
        }
        System.out.println(str);
    }
    //with recursion
    public static String replaceAllPi(String str,int si){
        if(si==str.length()-1)
            return str;
        if(str.charAt(si)=='p'){
            if(str.charAt(si+1)=='i'){
                str=str.substring(0,si)+"3.14"+str.substring(si+2);
            }
        }
        return replaceAllPi(str,si+1);
    }
}
