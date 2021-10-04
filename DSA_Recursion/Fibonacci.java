package DSA_Recursion;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(getFibbonaciterm(4));
    }
    public static int getFibbonaciterm(int n){
      if(n==1||n==0)
          return n;
      int fn1= getFibbonaciterm(n-1);
      int fn2= getFibbonaciterm(n-2);
      int fn=fn1+fn2;
      return fn;

    }
}
