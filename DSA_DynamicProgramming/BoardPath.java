package DSA_DynamicProgramming;

import java.util.HashMap;

public class BoardPath {
    public static void main(String[] args) {

        int n = 30;
        //System.out.println(BPRecursive(0,35));
        System.out.println(BPDpTd1(0, n, new int[n]));
        System.out.println(BPDpBu(0, n));
        System.out.println(bottomUpEfficient(0,n));
    }

    //O(6^n) time complexity
    public static int BPRecursive(int start, int dest) {
        //+ve base case
        if (start == dest) {
            //count++;
            return 1;
        }
        //-ve base case
        if (start > dest)
            return 0;
        int count = 0;
        for (int i = 1; i <= 6; i++) {
            count += BPRecursive(start + i, dest);
        }
        return count;
    }

    //O(n) time and space both
    //with hashmap data structure
    public static int BPDpTd(int start, int dest, HashMap<Integer, Integer> map) {
        //+ve base case
        if (start == dest) {
            return 1;
        }
        //-ve base case
        if (start > dest)
            return 0;

        int count = 0;
        for (int i = 1; i <= 6; i++) {
            if (map.containsKey(i + start))
                count += map.get(i + start);
            else {
                count += BPDpTd(start + i, dest, map);
            }
        }
        map.put(start, count);
        //System.out.println(map);
        return count;
    }

    //O(n) time and space =O(n)+recursion space
    //with array
    public static int BPDpTd1(int start, int dest, int[] storage) {
        //+ve base case
        if (start == dest) {
            return 1;
        }
        //-ve base case
        if (start > dest)
            return 0;

        if (storage[start] != 0)
            return storage[start];  //re use

        int count = 0;
        for (int i = 1; i <= 6; i++) {
            count += BPDpTd1(start + i, dest, storage);

        }
        storage[start] = count;   //store count

        return count;
    }

    ////O(n) time and space both
    //this will work for higher values of n like 1000000 and above
    //in the top-down method we have recursion space also so for higher values of n
    //we will get stack overflow exception so to overcome that issue we us bottom up method
    public static int BPDpBu(int start, int dest) {
        int[] storage=new int[dest+6];
        storage[dest]=1;  //base case in top down

        for (int i = dest-1; i >=0; i--) {
            storage[i]=storage[i+1]+storage[i+2]+storage[i+3]+storage[i+4]+storage[i+5]+storage[i+6];
        }

        return storage[0];
    }

    //O(n) time complexity
    //constant space complexity
    public static int bottomUpEfficient(int start,int dest){
        int[] storage=new int[7];

        storage[1]=1;

        for(int i = dest-1; i >=0; i--){
           storage[0]= storage[1]+storage[2]+storage[3]+storage[4]+storage[5]+storage[6];
           //this loop runs for the constant value 7 always
            for(int j=6;j>0;j--){
                storage[j]=storage[j-1];
            }
        }

        return storage[0];
    }


}
