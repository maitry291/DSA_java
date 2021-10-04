package DSA_Recursion_Arraylist;

import java.util.ArrayList;

public class Substring {
    public static void main(String[] args) {

        System.out.println(getString("abcd"));
       // printString("abc"," ");
    }
    public static ArrayList<String> getString(String str){
        if(str.isEmpty()){
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        char c=str.charAt(0);
        String s1=str.substring(1);

        ArrayList<String> s=new ArrayList<>();
        ArrayList<String> res=getString(s1);

        for(int i=0;i<res.size();i++){
            s.add(res.get(i));
            s.add(c+res.get(i));
        }
     return s;
    }
    public static void printString(String str,String res){
        if(str.isEmpty()){
            System.out.print(res+" ,");
            return;
        }
        char c=str.charAt(0);
        String s1=str.substring(1);
        printString(s1,res);
        printString(s1,res+c);

    }
}
