package DSA_Recursion;

public class Factorial {
    public static void main(String[] args) {
       // int n=5;
        System.out.println(factorial(5));
    }
    public static int factorial(int n){
        if(n==1)
            return 1;
        n=n* factorial(n-1);
        return n;
    }
}
