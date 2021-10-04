package DSA_TimeSpace_Complexity;
//full form=Sieve of Eratosthenes algorithm
//Best algorithm to find prime numbers according to time complexity.
//time complexity=O(n*log(log n))

import java.util.Arrays;

public class SOE_algorithm {
    public static void main(String[] args) {
     SOE(25);
    }
    public static void SOE(int n){
        boolean[] primes=new boolean[n+1];
        Arrays.fill(primes,true);
        primes[0]=primes[1]=false;
        for(int table=2;table*table<=n;table++){
            if(!primes[table])
                continue;
            for(int multi=2;table*multi<=n;multi++){
                primes[multi*table]=false;
            }
        }
        for(int i=0;i< primes.length;i++)
            if(primes[i])
            System.out.println(i);
    }
}
