package DSA_DynamicProgramming;

public class Fibonacci {
    public static void main(String[] args) {
       // System.out.println(fibDp(30,new int[31]));
        System.out.println(fibDpBU(7));
        System.out.println(fibDpBuEffi(7));
       // System.out.println(fibDp(100000,new int[100001]));
    }

    //O(2^n) very worst complexity
    public static int fibRecursive(int n){
        if(n==0||n==1){
            return n;
        }

        int fnm1=fibRecursive(n-1);
        int fnm2=fibRecursive(n-2);

        return fnm1+fnm2;
    }

    //O(n) time and space complexity =n+recursion space(which can't be reduced)
    //top-down dynamic programming
    //due to very large time in above method we can't get output for n =50 ,although 50 is not much bigger
    //still we won't get output ,so to overcome time complexity this method made
    public static int fibDp(int n,int[] storage){
        if(n==0||n==1){
            return n;
        }
        if(storage[n]!=0)
            return storage[n];  //re use

        int fnm1=fibDp(n-1,storage);
        int fnm2=fibDp(n-2,storage);

        int fn=fnm1+fnm2;
        storage[n]=fn;  //store

        return fn;
    }

    //when n have value very large like 10 power 5 then we can not have that much memory for recursion in stack
    //so we will get exception to stack overflow
    //to overcome this problem we use this method
    //in this bottom up method we fill array as per our requirement
    //bottom up dynamic programming

    ////O(n) time and space complexity =n
    public static int fibDpBU(int n){
        int[] storage= new int[n+1];
        //base case value fill
        storage[0]=0;
        storage[1]=1;
        //filling direction
        for(int i=2;i<n+1;i++){
            storage[i]=storage[i-1]+storage[i-2];
        }
        return storage[n];
    }

    //bottom up efficient
    ////O(n) time and space complexity =O(1)
    public static int fibDpBuEffi(int n){
        int[] a=new int[2];
        a[1]=1;
        for(int i=1;i<=n-1;i++){
            int temp=a[0]+a[1];
            a[0]=a[1];
            a[1]=temp;
        }
        return a[1];
    }
}
