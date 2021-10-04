package DSA_Recursion;

public class Pattern {
    public static void main(String[] args) {
       printPattern(6,1);
    }
    public static void printPattern(int n,int row){
        if(n==0)
            return ;
        printRow(row);
        System.out.println();
        printPattern(n-1,row+1);
    }
    public static void printRow(int row){
        if(row==0)
            return ;
        System.out.print("*");
        printRow(row-1);
    }
}
