package DSA_Recursion_Arraylist;
//to understand this diagrammatically refer to screenshots
//here we made a method to get all the ways to get 10 from dice,it can be any number or any starting point too.

import java.util.ArrayList;

public class BoardPaths {

    public static void main(String[] args) {
        System.out.println(getBoardPaths(0,10).size());
       // System.out.println(getBoardPaths(0,10));
        printBoardPath(0,4,"");

    }
    public static ArrayList<String> getBoardPaths(int current,int end){
        if(current==end){
            ArrayList<String> br=new ArrayList<>();
            br.add("");//br1 is of size 1 arraylist.
            return br;
        }
        if(current>end){
            ArrayList<String> br1=new ArrayList<>();
            //here we don't want to add this results so we are not adding any string in element
            //hence br1 will be an arraylist of size=0 so after returning it for loop of rr will not executed
            //hence negative results will not be stored in arraylist.
            return br1;
        }

        ArrayList<String> mr=new ArrayList<>();
        for(int dice=1;dice<=6;dice++){
            ArrayList<String> rr=new ArrayList<>();
            rr=getBoardPaths(current+dice,end);
            for(String str:rr){
                mr.add(dice+str);
            }
        }
        return mr;
    }
    public static void printBoardPath(int current,int end,String str){

        if(current==end){
            System.out.print(str+" ");
            return;
        }
        if(current>end){
            return;
        }
        for(int dice=1;dice<=6&&dice<=end;dice++){
            printBoardPath(current+dice,end,str+dice);
        }
    }
}
