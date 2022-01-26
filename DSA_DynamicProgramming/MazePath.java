package DSA_DynamicProgramming;

import java.util.Arrays;

public class MazePath {
    public static void main(String[] args) {
        int n=5;
        System.out.println(mazePathRecursive(0, 0, n, n));
        System.out.println(mazePathTdDp(0, 0, n, n, new int[n+1][n+1]));
        System.out.println(mazePathBuDp(n,n));
        System.out.println(mazePathBuSpaceEffi(n,n));

    }

    //time complexity O(2^(er+ec)) very bad
    public static int mazePathRecursive(int sr, int sc, int er, int ec) {
        //-ve base case
        if (sr > er || sc > ec) {
            return 0;
        }
        //+ve base case
        if (sr == er && sc == ec) {
            return 1;
        }
        int count = 0;
        count += mazePathRecursive(sr, sc + 1, er, ec);
        count += mazePathRecursive(sr + 1, sc, er, ec);

        return count;
    }

    //O(er*ec) time complexity and space complexity=O(er*ec)+recursion space
    //top down dynamic programming
    public static int mazePathTdDp(int sr, int sc, int er, int ec, int[][] storage) {
        //-ve base case
        if (sr > er || sc > ec) {
            return 0;
        }
        //+ve base case
        if (sr == er && sc == ec) {
            return 1;
        }
        //re use
        if (storage[sr][sc] != 0)
            return storage[sr][sc];

        int count = 0;
        count += mazePathTdDp(sr, sc + 1, er, ec, storage);
        count += mazePathTdDp(sr + 1, sc, er, ec, storage);

        storage[sr][sc] = count;  //store

        return count;
    }

    //O(er*ec) time complexity and space complexity=O(er*ec)
    //bottom up dynamic programming to overcome recursive space
    public static int mazePathBuDp( int er, int ec) {
        int[][] storage = new int[er + 2][ec + 2];
        storage[er][ec] = 1;  //base case

        for (int i = er; i >= 0; i--) {
            for (int j = ec; j >= 0; j--) {
                if (i == er && j == ec)
                    continue;
                storage[i][j] = storage[i + 1][j] + storage[i][j + 1];
            }
        }
        return storage[0][0];
    }

    //O(er*ec) time complexity and space complexity=O(ec)
    public static int mazePathBuSpaceEffi(int er,int ec){
        int[] storage=new int[ec+1];
        Arrays.fill(storage,1);

        for (int i = er; i > 0; i--) {
           for(int j=ec-1;j>=0;j--){
               storage[j]+=storage[j+1];
           }
        }
        return storage[0];
    }

}
