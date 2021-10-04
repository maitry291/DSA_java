package DSA_Recursion_Arraylist;

import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
        System.out.println(getPermutation("abc"));
        printPermutation("abc","");

    }
    public static ArrayList<String> getPermutation(String str){
        if(str.isEmpty()){
            ArrayList<String> base=new ArrayList<>();
            base.add("");//br1 is of size 1 arraylist.
            return base;
        }
        char c=str.charAt(0);
        String s1=str.substring(1);

        ArrayList<String> s=new ArrayList<>();
        ArrayList<String> res=getPermutation(s1);

        for(String s2:res) {
            for (int i = 0; i <=s2.length(); i++) {
                s.add(s2.substring(0, i) + c + s2.substring(i));//to understand this in deep refer screenshots.
                //in substring(0,i) ith character is not included ex.hello.substring(0,1)="h"-->e is excluded.
                //bt in substring(i) ith character is included.ex.hello.substring(1)="ello"
            }
        }
        return s;
    }
    public static void printPermutation(String str,String res){
        if(str.isEmpty()){
            System.out.print(res+" ");
            return;
        }
        for(int i=0;i<str.length();i++) {
            char c=str.charAt(i);
            String s1 =str.substring(0,i)+ str.substring(i+1);
            printPermutation(s1, res+c);

        }


    }
}
