package DSA_Recursion_Arraylist;

import java.awt.*;//how to do this method with pointers.

//matrix is given in it we have to find each possible paths from given possible steps.
import java.util.ArrayList;

public class MazePath {
    public static void main(String[] args) {
        System.out.println(getMazePath(0,0,2,2));
        printMazePath(0,0,2,2,"");
        //with point class
        System.out.println(getMazePathp(new Point(0,0),new Point(2,2)));
    }
    public static ArrayList<String> getMazePath(int cr,int cc,int er,int ec){
        if(cr==er&&cc==ec){
            ArrayList<String> br=new ArrayList<>();
            br.add("");//br1 is of size 1 arraylist.
            return br;
        }
        if(cr>er||cc>ec){
            //here we don't want to add this results so we are not adding any string in element
            //hence br1 will be an arraylist of size=0 so after returning it for loop of rr will not executed
            //hence negative results will not be stored in arraylist.
            return new ArrayList<>();
        }
        ArrayList<String> mr=new ArrayList<>();
        ArrayList<String> rrh=getMazePath(cr,cc+1,er,ec);
        for(String s:rrh){     //horizontal step
            mr.add("H"+s);
        }
        ArrayList<String> rrv=getMazePath(cr+1,cc,er,ec);
        for(String s1:rrv){     //vertical step
            mr.add("V"+s1);
        }
        ArrayList<String> rrd=getMazePath(cr+1,cc+1,er,ec);
        for(String s2:rrd){       //Diagonal step
            mr.add("D"+s2);
        }

       return mr;
    }
    public static void printMazePath(int cr,int cc,int er,int ec,String ans){
        if(cr==er&&cc==ec){
            System.out.print(ans+" ");
            return;
        }
        if(cr>er||cc>ec){
            return;
        }
        printMazePath(cr,cc+1,er,ec,ans+"H");
        printMazePath(cr+1,cc,er,ec,ans+"V");
        printMazePath(cr+1,cc+1,er,ec,ans+"D");
    }
    //with point class
    public static ArrayList<String> getMazePathp(Point a, Point b){
        if(a.x==b.x&&a.y==b.y){
            ArrayList<String> br=new ArrayList<>();
            br.add("");//br1 is of size 1 arraylist.
            return br;
        }
        if(a.x>b.x||a.y>b.y){
            //here we don't want to add this results so we are not adding any string in element
            //hence br1 will be an arraylist of size=0 so after returning it for loop of rr will not executed
            //hence negative results will not be stored in arraylist.
            return new ArrayList<>();
        }
        ArrayList<String> mr=new ArrayList<>();
        ArrayList<String> rrh=getMazePathp(new Point(a.x,a.y+1),b);
        for(String s:rrh){     //horizontal step
            mr.add("H"+s);
        }
        ArrayList<String> rrv=getMazePathp(new Point(a.x+1,a.y),b);
        for(String s1:rrv){     //vertical step
            mr.add("V"+s1);
        }
        ArrayList<String> rrd=getMazePathp(new Point(a.x+1,a.y+1),b);
        for(String s2:rrd){       //Diagonal step
            mr.add("D"+s2);
        }

        return mr;
    }
}
