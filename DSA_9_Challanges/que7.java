package DSA_9_Challanges;

public class que7 {
    public static void main(String[] args) {
        generateParentheses(3,"");
       // printParenthesis(2,"",0,2,0);
    }
    public static void generateParentheses(int n,String ans){
        if(n==0){
            System.out.println(ans);
            return;
        }
       generateParentheses(n-1,ans+"()");
        if(!ans.isEmpty())
       generateParentheses(n-1,"("+ans+")");
    }
    //this method is copied and pasted from solution
    public static void printParenthesis(int n, String ans, int close, int limit, int open) {

        if (n == 0) {
            System.out.println(ans);
            return;
        }

        if(close < open && open != 0) {
            printParenthesis(n - 1, ans + ")", close + 1, limit, open);
        }
        if (open < limit) {
            printParenthesis(n - 1, ans + "(", close, limit, open + 1);
        }
    }
}
