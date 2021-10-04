package DSA_Recursion;

public class Powerfunction {
    public static void main(String[] args) {
        System.out.println(power(3,5));
    }
    public static int power(int x,int n){
        if(n==1)
            return x;
      int res=x* power(x,n-1);
       return res;
    }
}
